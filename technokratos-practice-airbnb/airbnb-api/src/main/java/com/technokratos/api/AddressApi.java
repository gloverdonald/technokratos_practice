package com.technokratos.api;

import com.technokratos.dto.request.DaDataAddressRequest;
import com.technokratos.dto.response.AddressResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/address")
public interface AddressApi {

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    AddressResponse create(@RequestBody DaDataAddressRequest address);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AddressResponse get(@PathVariable UUID id);
}
