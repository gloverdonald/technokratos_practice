package com.technokratos.dto.request;

import com.technokratos.validation.annotations.ValidBookingDates;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Бронирование")
@ValidBookingDates
public class BookingRequest {
    @ApiModelProperty(value = "Дата въезда", example = "2022-04-25")
    private Date dateIn;

    @ApiModelProperty(value = "Дата выезда", example = "2022-04-25")
    private Date dateOut;
}
