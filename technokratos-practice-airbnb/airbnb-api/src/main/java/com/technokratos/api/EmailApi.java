package com.technokratos.api;

import com.technokratos.dto.request.LoginRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/email/confirm")
public interface EmailApi {

    @ApiOperation(value = "Подтверждение почты", produces = "text/plain")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Подтверждение")})
    @GetMapping("/{confirm-code}")
    @ResponseStatus(HttpStatus.OK)
    Boolean emailConfirmation(@ApiParam(value = "Код подтверждения") @PathVariable("confirm-code") String confirmCode);

    @ApiOperation(value = "Получение кода подтверждения почты")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void getConfirmationToken(@ApiParam(value = "Логин и пароль") @RequestBody LoginRequest userRequest);

}
