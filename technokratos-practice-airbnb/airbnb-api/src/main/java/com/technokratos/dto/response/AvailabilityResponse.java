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
@ApiModel(value = "Доступный для бронирования период")
public class AvailabilityResponse {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Дата начала")
    private Date dateFrom;

    @ApiModelProperty(value = "Дата конца")
    private Date dateTo;

    @ApiModelProperty(value = "Апартамент")
    private ApartmentResponse apartment;

    @ApiModelProperty(value = "Удален")
    private Boolean deleted;
}
