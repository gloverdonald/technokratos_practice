package com.technokratos.api;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.request.TokenRefreshRequest;
import com.technokratos.dto.response.TokensResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/auth")
public interface AuthApi {

    @PostMapping(value = "/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody RegistrationRequest userRequest);

    @PostMapping(value = "/sign-in")
    @ResponseStatus(HttpStatus.OK)
    TokensResponse login(@RequestBody LoginRequest userRequest);

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    TokensResponse refresh(@RequestBody TokenRefreshRequest request);

    @GetMapping("/oauth/token")
    @ResponseStatus(HttpStatus.OK)
    TokensResponse getOAuthTokens(Authentication authentication);
}
