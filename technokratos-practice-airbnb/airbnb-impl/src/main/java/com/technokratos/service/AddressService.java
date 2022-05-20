package com.technokratos.service;

import com.technokratos.dto.request.AddressRequest;
import com.technokratos.dto.response.AddressResponse;

import java.util.UUID;

public interface AddressService {

    AddressResponse create(AddressRequest addressRequest);

    AddressResponse create(String address);

    AddressResponse get(UUID id);
}
