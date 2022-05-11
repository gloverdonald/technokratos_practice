package com.technokratos.service;

import com.technokratos.dto.request.TokenRefreshRequest;
import com.technokratos.dto.response.TokensResponse;
import com.technokratos.dto.response.UserResponse;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public interface TokenService {
    TokensResponse generateTokens(UserResponse userResponse);

    TokensResponse refreshTokens(TokenRefreshRequest request);

    TokensResponse generateOAuthTokens(DefaultOAuth2User oAuth2User);
}