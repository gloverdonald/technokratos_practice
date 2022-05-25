package com.technokratos.dto.request;

import com.technokratos.validation.annotations.CustomPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @Email
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8, max = 100, message = "минимальный размер {min}, максимальный размер {max}")
    @CustomPassword
    private String password;
}
