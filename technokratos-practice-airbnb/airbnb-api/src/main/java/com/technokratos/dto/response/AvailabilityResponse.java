package com.technokratos.dto.response;

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
public class AvailabilityResponse {
    private UUID id;

    private Date dateFrom;

    private Date dateTo;

    private ApartmentResponse apartment;

    private Boolean deleted;
}
