package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Авторизация")
public class LoginRequest {

    @ApiModelProperty(value = "Электронная почта", example = "mimi@gmail.com")
    private String email;

    @ApiModelProperty(value = "Пароль")
    private String password;
}

