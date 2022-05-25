package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Роль")
public class RoleResponse {

    @ApiModelProperty(value = "Роль")
    private String role;

    @ApiModelProperty(value = "Описание роли")
    private String description;
}
