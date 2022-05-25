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
@ApiModel(value = "Фото")
public class PhotoResponse {

    @ApiModelProperty(value = "Идентификатор")
    private String id;

    @ApiModelProperty(value = "Название")
    private String name;

    @ApiModelProperty(value = "Тип файла")
    private String type;

    @ApiModelProperty(value = "Размер")
    private String size;

    @ApiModelProperty(value = "Фото в виде массива байтов")
    private byte[] photo;
}
