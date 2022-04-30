package com.technokratos.api;

import com.technokratos.dto.request.LogoutRequest;
import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.request.TokenRefreshRequest;
import com.technokratos.dto.response.TokensResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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

}
