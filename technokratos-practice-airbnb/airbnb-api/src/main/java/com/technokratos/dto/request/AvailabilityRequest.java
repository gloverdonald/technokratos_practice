package com.technokratos.dto.request;

import com.technokratos.validation.annotations.ValidAvailabilityDates;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

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

    @ApiModelProperty(value = "Идентификатор апартамента", example = "43ab999e-1ff7-47e7-b809-775272c38ec9")
    @NotNull
    private UUID apartmentId;

}
