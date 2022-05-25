package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Апартамент")
public class ApartmentRequest {

    @ApiModelProperty(value = "Цена", example = "2000")
    private Integer price;

    @ApiModelProperty(value = "Полное описание")
    private String descriptionLong;

    @ApiModelProperty(value = "Короткое описание")
    private String descriptionShort;

    @ApiModelProperty(value = "Владелец", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    private UUID ownerId;

    @ApiModelProperty(value = "Идентификатор адреса", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    private UUID addressId;

    @ApiModelProperty(value = "Идентификатор информации", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    private UUID infoId;
}
