package com.technokratos.dto.request;

import com.technokratos.dto.enums.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Регистрация")
public class RegistrationRequest extends LoginRequest {

    @ApiModelProperty(value = "Имя", example = "Вероника")
    private String firstName;

    @ApiModelProperty(value = "Фамилия", example = "Сойер")
    private String lastName;

    @ApiModelProperty(value = "Роли", example = "USER")
    private List<Role> roles;
}
