package com.technokratos.dto.request;

import com.technokratos.dto.enums.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Регистрация")
public class RegistrationRequest extends LoginRequest {

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 20, message = "минимальный размер {min}, максимальный размер {max}")
    @ApiModelProperty(value = "Имя", example = "Вероника")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 20, message = "минимальный размер {min}, максимальный размер {max}")
    @ApiModelProperty(value = "Фамилия", example = "Сойер")
    private String lastName;

    @ApiModelProperty(value = "Роли", example = "USER")
    private List<Role> roles;
}
