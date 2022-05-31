package com.technokratos.api;

import com.technokratos.dto.request.AddressRequest;
import com.technokratos.dto.request.DaDataAddressRequest;
import com.technokratos.dto.response.AddressResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/address")
public interface AddressApi {
    @ApiOperation(value = "Добавление адреса DaData", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленный адрес DaData",
                    response = AddressResponse.class)})
    @PostMapping(value = "/add-dadata")
    @ResponseStatus(HttpStatus.CREATED)
    AddressResponse create(@ApiParam(value = "Адрес DaData") @RequestBody DaDataAddressRequest address);

    @ApiOperation(value = "Добавление адреса", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленный адрес",
                    response = AddressResponse.class)})
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    AddressResponse create(@ApiParam(value = "Данные адреса") @RequestBody AddressRequest address);

    @ApiOperation(value = "Получение адреса", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Полученный адрес",
                    response = AddressResponse.class)})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AddressResponse get(@ApiParam(value = "Идентификатор адреса") @PathVariable UUID id);
}
