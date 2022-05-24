package com.technokratos.controller;

import com.technokratos.api.AddressApi;
import com.technokratos.dto.request.DaDataAddressRequest;
import com.technokratos.dto.response.AddressResponse;
import com.technokratos.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class AddressController implements AddressApi {

    private final AddressService addressService;

    @Override
    public AddressResponse create(DaDataAddressRequest address) {
        return addressService.create(address.getAddress());
    }

    @GetMapping("/{id}")
    public AddressResponse get(@PathVariable UUID id) {
        return addressService.get(id);
    }
}
