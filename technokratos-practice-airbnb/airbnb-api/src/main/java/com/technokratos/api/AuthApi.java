package com.technokratos.api;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.request.TokenRefreshRequest;
import com.technokratos.dto.response.TokensResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/auth")
public interface AuthApi {

    @ApiOperation(value = "Регистрация", produces = "text/plain")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Идентификатор зарегистрированного")})
    @PostMapping(value = "/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@ApiParam(value = "Данные для регистрации") @RequestBody RegistrationRequest userRequest);

    @ApiOperation(value = "Авторизация", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пара токенов",
                    response = TokensResponse.class)})
    @PostMapping(value = "/sign-in")
    @ResponseStatus(HttpStatus.OK)
    TokensResponse login(@ApiParam(value = "Логин и пароль") @RequestBody LoginRequest userRequest);

    @ApiOperation(value = "Обновление токенов", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пара токенов",
                    response = TokensResponse.class)})
    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    TokensResponse refresh(@ApiParam(value = "старый refresh токен") @RequestBody TokenRefreshRequest request);

    @ApiOperation(value = "Получение токенов oauth", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пара токенов",
                    response = TokensResponse.class)})
    @GetMapping("/oauth/token")
    @ResponseStatus(HttpStatus.OK)
    TokensResponse getOAuthTokens(Authentication authentication);

}
