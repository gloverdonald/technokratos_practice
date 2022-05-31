package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Адрес dadata")
public class DaDataAddressRequest {

    @ApiModelProperty(value = "Адрес")
    @NotBlank(message = "Должен быть адрес")
    private String address;
}
