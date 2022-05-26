package com.technokratos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentInfoResponse {
    private UUID id;

    private Boolean parking;

    private Boolean pool;

    private Boolean microwave;

    private Boolean iron;

    private Boolean refrigerator;

    private Boolean conditioner;

    private Boolean garage;

    private Boolean heat;

    private Boolean washingMachine;

    private ApartmentResponse apartment;

    private Boolean deleted;
}
