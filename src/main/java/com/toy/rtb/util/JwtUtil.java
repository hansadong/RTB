package com.toy.rtb.util;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtUtil {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    // 토큰 생성
    public String generateJwtToken(String memberId) {
        return Jwts.builder()
                .setSubject(memberId)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // 토큰에서 사용자 이름 추출
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 토큰에서 유효기간 추출
    public Date getExpirationMsFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    // 토큰 유효성 검사
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage(), e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage(), e);
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage(), e);
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage(), e);
        }
        return false;
    }
}
