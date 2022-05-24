package com.technokratos.dto.request;

import com.technokratos.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest extends LoginRequest {

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 20, message = "минимальный размер {min}, максимальный размер {max}")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 20, message = "минимальный размер {min}, максимальный размер {max}")
    private String lastName;

    private List<Role> roles;
}
