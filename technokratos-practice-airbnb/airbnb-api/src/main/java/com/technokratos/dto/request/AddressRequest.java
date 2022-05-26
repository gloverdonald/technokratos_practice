package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Адрес")
public class AddressRequest {

    @NotBlank(message = "Адрес должен иметь название страны")
    @Size(min = 2, max = 50, message = "минимальный размер названия страны - {min}, максимальный - {max}")
    @ApiModelProperty(value = "Страна")
    private String country;

    @NotBlank(message = "Адрес должен иметь название региона")
    @Size(min = 2, max = 50, message = "минимальный размер названия региона - {min}, максимальный - {max}")
    @ApiModelProperty(value = "Регион")
    private String region;

    @NotBlank(message = "Адрес должен иметь название населенного пункта")
    @Size(min = 2, max = 50, message = "минимальный размер названия населенного пункта - {min}, максимальный - {max}")
    @ApiModelProperty(value = "Населенный пункт")
    private String city;

    @NotBlank(message = "Адрес должен иметь название улицы")
    @Size(min = 2, max = 50, message = "минимальный размер названия улицы - {min}, максимальный - {max}")
    @ApiModelProperty(value = "Улица")
    private String street;

    @NotBlank(message = "Адрес должен иметь номер дома")
    @Size(min = 1, max = 5, message = "минимальный размер номера дома - {min}, максимальный - {max}")
    @ApiModelProperty(value = "Номер дома")
    private String houseNumber;

    @ApiModelProperty(value = "Номер квартиры")
    private String flatNumber;

    @ApiModelProperty(value = "Индекс")
    @NotBlank(message = "Адрес должен иметь почтовый индекс")
    private String postalCode;
}