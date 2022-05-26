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
@ApiModel(value = "Информация об апартаменте")
public class ApartmentInfoRequest {

    @ApiModelProperty(value = "Парковка")
    private Boolean parking;

    @ApiModelProperty(value = "Бассейн")
    private Boolean pool;

    @ApiModelProperty(value = "Микроволновка")
    private Boolean microwave;

    @ApiModelProperty(value = "Утюг")
    private Boolean iron;

    @ApiModelProperty(value = "Холодильник")
    private Boolean refrigerator;

    @ApiModelProperty(value = "Кондиционер")
    private Boolean conditioner;

    @ApiModelProperty(value = "Гараж")
    private Boolean garage;

    @ApiModelProperty(value = "Обогреватель")
    private Boolean heat;

    @ApiModelProperty(value = "Стиральная машина")
    private Boolean washingMachine;
}
