package com.technokratos.controller;

import com.technokratos.api.AuthApi;
import com.technokratos.dto.request.LogOutRequest;
import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.request.TokenRefreshRequest;
import com.technokratos.dto.response.TokensResponse;
import com.technokratos.service.TokenServise;
import com.technokratos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final UserService userService;

    private final TokenServise tokenServise;

    @GetMapping("/test")
    public String test() {
        return "tested";
    }

    @Override
    public UUID create(RegistrationRequest userRequest) {
        return userService.create(userRequest);
    }

    @Override
    public TokensResponse login(LoginRequest userRequest) {
        return tokenServise.generateTokens(userService.login(userRequest));
    }

    @Override
    public TokensResponse refresh(TokenRefreshRequest request) {
        return tokenServise.refreshTokens(request);
    }

    @Override
    public void logout(LogOutRequest logOutRequest) {

    }
}
