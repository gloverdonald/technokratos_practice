package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Апартамент")
public class ApartmentRequest {
    @ApiModelProperty(value = "Цена", example = "2000")
    @NotNull
    @Min(1)
    private Integer price;

    @ApiModelProperty(value = "Полное описание")
    @Size(max = 5100, message = "максимальный размер описания - {max}")
    private String descriptionLong;

    @ApiModelProperty(value = "Короткое описание")
    @Size(max = 255, message = "максимальный размер описания - {max}")
    private String descriptionShort;

    @ApiModelProperty(value = "Идентификатор адреса", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    private UUID addressId;
}
