package com.toy.rtb.util.auth;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${jwt.secret}")
    private String jwtSecret;

    // 토큰 generate
    public String generateToken(String memberId, long expirationTimeInMs, Map<String, Object> claims) {
        return createToken(claims, memberId, expirationTimeInMs);
    }

    // 토큰 생성
    private String createToken(Map<String, Object> claims, String memberId, long expirationTimeInMs) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(memberId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // 토큰에서 memberId 추출
    public Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }

    // 토큰 유효성 검사
    public boolean isTokenExpired(String token) {
        final Date expiration = extractClaims(token).getExpiration();
        return expiration.before(new Date());
    }

}
