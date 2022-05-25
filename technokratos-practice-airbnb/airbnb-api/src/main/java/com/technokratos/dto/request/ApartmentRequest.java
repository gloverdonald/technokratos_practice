package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentRequest {
    private Integer price;

    private String descriptionLong;

    private String descriptionShort;

    private UUID ownerId;

    private UUID addressId;

    private UUID infoId;
}
