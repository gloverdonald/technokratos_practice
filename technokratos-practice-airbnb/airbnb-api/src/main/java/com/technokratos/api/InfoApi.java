package com.technokratos.api;

import com.technokratos.dto.request.ApartmentInfoRequest;
import com.technokratos.dto.response.AddressResponse;
import com.technokratos.dto.response.ApartmentInfoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/apartments/info")
public interface InfoApi {

    @ApiOperation(value = "Добавление информации об апартаменте", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленная информация",
                    response = ApartmentInfoResponse.class)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{apartment-id}")
    ApartmentInfoResponse createApartmentInfo(@ApiParam(value = "Идентификатор апартамента")
                                              @PathVariable("apartment-id") UUID apartmentId,
                                              @ApiParam(value = "Информация об апартаменте")
                                              @Valid @RequestBody ApartmentInfoRequest apartmentInfoRequest);

    @ApiOperation(value = "Получение информации об апартаменте", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Полученная информация",
                    response = ApartmentInfoResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{apartment-id}")
    ApartmentInfoResponse getApartmentInfoByApartment(@ApiParam(value = "Идентификатор апартамента")
                                                      @PathVariable("apartment-id") UUID apartmentId);

    @ApiOperation(value = "Обновление информации об апартаменте", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Обновленная информация",
                    response = ApartmentInfoResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{apartment-id}")
    ApartmentInfoResponse updateApartmentInfoByApartment(@ApiParam(value = "Идентификатор апартамента")
                                                         @PathVariable("apartment-id") UUID apartmentId,
                                                         @ApiParam(value = "Информация об апартаменте")
                                                         @Valid @RequestBody ApartmentInfoRequest apartmentInfoRequest);
}
