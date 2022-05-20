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
public class AddressResponse {

    private UUID id;

    private String country;

    private String region;

    private String city;

    private String street;

    private String houseNumber;

    private String flatNumber;

    private String postalCode;

    private UUID apartmentId;
}