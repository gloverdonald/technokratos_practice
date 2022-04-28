package com.technokratos.service;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.TokenRefreshRequest;
import com.technokratos.dto.response.TokensResponse;
import com.technokratos.dto.response.UserResponse;

public interface TokenServise {
    TokensResponse generateTokens(UserResponse userResponse);

    TokensResponse refreshTokens(TokenRefreshRequest request);
}
