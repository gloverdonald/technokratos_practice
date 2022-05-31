package com.technokratos.dto.request;

import com.technokratos.validation.annotations.ValidAvailabilityDates;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Доступный для бронирования период")
@ValidAvailabilityDates
public class AvailabilityRequest {
    @ApiModelProperty(value = "Дата начала", example = "2022-04-25")
    private Date dateFrom;

    @ApiModelProperty(value = "Дата конца", example = "2022-04-26")
    private Date dateTo;
}