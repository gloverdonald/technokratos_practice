package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {

    private String country;

    private String region;

    private String city;

    private String street;

    private String houseNumber;

    private String flatNumber;

    private String postalCode;
}