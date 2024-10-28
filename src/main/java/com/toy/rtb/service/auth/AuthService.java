package com.toy.rtb.service.auth;

public interface AuthService {
    public String generateAccessToken(String username);

    public String generateRefreshToken(String username);
}
