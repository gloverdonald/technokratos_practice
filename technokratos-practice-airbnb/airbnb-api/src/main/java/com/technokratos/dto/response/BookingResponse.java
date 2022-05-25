package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Бронирование")
public class BookingResponse {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Дата въезда")
    private Date dateIn;

    @ApiModelProperty(value = "Дата выезда")
    private Date dateOut;

    @ApiModelProperty(value = "Апартамент")
    private ApartmentResponse apartment;

    @ApiModelProperty(value = "Удален")
    private Boolean deleted;
}
