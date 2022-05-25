package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Адрес")
public class AddressRequest {

    @ApiModelProperty(value = "Страна")
    private String country;

    @ApiModelProperty(value = "Регион")
    private String region;

    @ApiModelProperty(value = "Населенный пункт")
    private String city;

    @ApiModelProperty(value = "Улица")
    private String street;

    @ApiModelProperty(value = "Номер дома")
    private String houseNumber;

    @ApiModelProperty(value = "Номер квартиры")
    private String flatNumber;

    @ApiModelProperty(value = "Индекс")
    private String postalCode;
}