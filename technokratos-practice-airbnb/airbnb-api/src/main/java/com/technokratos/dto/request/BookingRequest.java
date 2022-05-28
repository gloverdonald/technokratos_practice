package com.technokratos.dto.request;

import com.technokratos.validation.annotations.ValidBookingDates;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

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

    @ApiModelProperty(value = "Идентификатор апартамента", example = "43ab999e-1ff7-47e7-b809-775272c38ec9")
    @NotNull
    private UUID apartmentId;
}
