package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Апартамент")
public class ApartmentResponse {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Цена")
    private Integer price;

    @ApiModelProperty(value = "Полное описание")
    private String descriptionLong;

    @ApiModelProperty(value = "Короткое описание")
    private String descriptionShort;

    @ApiModelProperty(value = "Хозяин")
    private UserResponse owner;

    @ApiModelProperty(value = "Удален")
    private Boolean deleted;

    private AddressResponse address;

    private ApartmentInfoResponse info;
}

