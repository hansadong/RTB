package com.toy.rtb.controller.auth;

import com.toy.rtb.dto.JwtResponseDTO;
import com.toy.rtb.dto.LoginRequestDTO;
import com.toy.rtb.dto.SignupRequestDTO;
import com.toy.rtb.model.member.Member;
import com.toy.rtb.service.auth.AuthService;
import com.toy.rtb.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    // 로그인 요청 처리
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(LoginRequestDTO loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getMemberId(),
                            loginRequest.getMemberPwd()));

            // 인증 성공 시 JWT 토큰 생성
            String accessToken = authService.generateAccessToken(loginRequest.getMemberId());
            String refreshToken = authService.generateRefreshToken(loginRequest.getMemberId());

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponseDTO(accessToken, refreshToken, userDetails.getUsername()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(SignupRequestDTO signUpRequest) {
        // 사용자 등록 로직 구현 (이미 존재하는 사용자 체크 등)
        // 예시로 간단히 구현
        if (memberService.getMemberByMemberId(signUpRequest.getMemberId()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: 이미 사용 중인 아이디입니다.");
        }

        // 패스워드 인코딩
        String encodedPassword = passwordEncoder.encode(signUpRequest.getMemberPwd());

        // 사용자 저장
        Member member = new Member();
        member.setMemberId(signUpRequest.getMemberId());
        member.setMemberPwd(encodedPassword);
        memberService.saveMember(member);

        return ResponseEntity.ok("Success: 회원 등록 성공!");
    }
}