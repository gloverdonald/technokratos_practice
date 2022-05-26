package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Отзыв об апартаменте")
public class ApartmentReviewRequest {

    @Min(value = 1, message = "Оценка не может быть меньше 1")
    @Max(value = 5, message = "Оценка не может быть больше 5")
    @ApiModelProperty(value = "Оценка")
    private Integer rating;

    @Size(min = 5, max = 5100, message = "минимальный размер отзыва - {min}, максимальный - {max}")
    @ApiModelProperty(value = "Комментарий")
    private String comment;
}
