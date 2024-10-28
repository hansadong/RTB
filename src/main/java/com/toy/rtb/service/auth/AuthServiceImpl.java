package com.toy.rtb.service.auth;

import com.toy.rtb.util.auth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JwtUtil jwtUtil;

    public String generateAccessToken(String memberId) {
        // 액세스 토큰 만료기간 세팅 (15분)
        long expirationTimeInMs = 15 * 60 * 1000;
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("type", "access");
        return jwtUtil.generateToken(memberId, expirationTimeInMs, claims);
    }

    public String generateRefreshToken(String memberId) {
        // 리프레쉬 토큰 만료기간 세팅 (30일)
        long expirationTimeInMs = 7 * 24 * 60 * 60 * 1000;
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("type", "refresh");
        return jwtUtil.generateToken(memberId, expirationTimeInMs, claims);
    }
}
