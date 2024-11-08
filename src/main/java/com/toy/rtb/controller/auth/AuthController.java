package com.toy.rtb.controller.auth;

import com.toy.rtb.dto.JwtResponseDTO;
import com.toy.rtb.dto.SignupRequestDTO;
import com.toy.rtb.dto.TokenRequestDTO;
import com.toy.rtb.model.member.Member;
import com.toy.rtb.service.auth.AuthService;
import com.toy.rtb.service.member.MemberService;
import com.toy.rtb.util.auth.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.cookie-name}")
    private String jwtCookieName;

    // 로그인 요청 처리
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(TokenRequestDTO loginRequest, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getMemberId(),
                            loginRequest.getMemberPwd()));

            logger.info("request : {}, {}", loginRequest.getMemberId(), loginRequest.getMemberPwd());

            // 인증 성공 시 JWT 토큰 생성
            String accessToken = authService.generateAccessToken(loginRequest.getMemberId());
            String refreshToken = authService.generateRefreshToken(loginRequest.getMemberId());

            logger.info("accessToken : {}, refreshToken : {}", accessToken, refreshToken);

            Cookie cookie = new Cookie(jwtCookieName, refreshToken);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            response.addCookie(cookie);

            logger.info("cookie 세팅 성공!");

            return ResponseEntity.ok(new JwtResponseDTO(accessToken));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(SignupRequestDTO signUpRequest) {
        Member memberByMemberId = memberService.getMemberByMemberId(signUpRequest.getMemberId());
        Member memberByNickName = memberService.getMemberByNickName(signUpRequest.getNickName());
        if (memberByMemberId != null) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: 이미 사용 중인 아이디입니다.");
        } else if (memberByNickName != null) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: 이미 사용 중인 닉네임입니다.");
        }

        // 패스워드 인코딩
        String encodedPassword = passwordEncoder.encode(signUpRequest.getMemberPwd());

        // 사용자 저장
        Member member = new Member();
        member.setMemberId(signUpRequest.getMemberId());
        member.setMemberPwd(encodedPassword);
        member.setMemberEmail(signUpRequest.getMemberEmail());
        member.setNickName(signUpRequest.getNickName());
        memberService.saveMember(member);

        return ResponseEntity.ok("Success: 회원 등록 성공!");
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@CookieValue(name = "${jwt.cookie-name}", required = false) String refreshToken
            , HttpServletResponse response) {
        // refresh 토큰 유효성 검사
        if (refreshToken == null || jwtUtil.isTokenExpired(refreshToken)) {
            // refresh 토큰 만료로 재로그인 필요
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }

        // 리프레쉬 토큰에서 memberId 추출
        String memberId = jwtUtil.extractClaims(refreshToken).getSubject();

        // new access token 생성하여 응답
        String newAccessToken = authService.generateAccessToken(memberId);

        Cookie accessCookie = new Cookie(jwtCookieName, newAccessToken);
        accessCookie.setHttpOnly(true);
        accessCookie.setSecure(true);
        accessCookie.setPath("/");
        response.addCookie(accessCookie);

        return ResponseEntity.ok(new JwtResponseDTO(newAccessToken));
    }
}
