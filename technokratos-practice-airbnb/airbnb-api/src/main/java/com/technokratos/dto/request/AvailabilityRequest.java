package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Доступный для бронирования период")
public class AvailabilityRequest {

    @ApiModelProperty(value = "Дата начала", example = "2022-04-25")
    @FutureOrPresent
    private Date dateFrom;

    @Future
    @ApiModelProperty(value = "Дата конца", example = "2022-04-25")
    private Date dateTo;

    @ApiModelProperty(value = "Идентификатор апартамента", example = "43ab999e-1ff7-47e7-b809-775272c38ec9")
    private UUID apartmentId;

}
