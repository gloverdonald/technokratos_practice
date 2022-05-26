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
@ApiModel(value = "Отзыв об апартаменте")
public class ApartmentReviewResponse {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Оценка")
    private Integer rating;

    @ApiModelProperty(value = "Комментарий")
    private String comment;

    @ApiModelProperty(value = "Апартамент")
    private ApartmentResponse apartment;

    @ApiModelProperty(value = "Удален")
    private Boolean deleted;
}
