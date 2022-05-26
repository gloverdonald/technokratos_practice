package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentInfoRequest {
    private Boolean parking;

    private Boolean pool;

    private Boolean microwave;

    private Boolean iron;

    private Boolean refrigerator;

    private Boolean conditioner;

    private Boolean garage;

    private Boolean heat;

    private Boolean washingMachine;
}
