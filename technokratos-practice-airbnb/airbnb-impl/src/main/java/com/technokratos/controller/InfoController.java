package com.technokratos.controller;

import com.technokratos.api.InfoApi;
import com.technokratos.dto.request.ApartmentInfoRequest;
import com.technokratos.dto.response.ApartmentInfoResponse;
import com.technokratos.service.ApartmentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class InfoController implements InfoApi {
    private final ApartmentInfoService apartmentInfoService;

    @Override
    public ApartmentInfoResponse createApartmentInfo(UUID apartmentId, ApartmentInfoRequest apartmentInfoRequest) {
        return apartmentInfoService.create(apartmentId, apartmentInfoRequest);
    }

    @Override
    public ApartmentInfoResponse getApartmentInfoByApartment(UUID apartmentId) {
        return apartmentInfoService.get(apartmentId);
    }

    @Override
    public ApartmentInfoResponse updateApartmentInfoByApartment(UUID apartmentId, ApartmentInfoRequest apartmentInfoRequest) {
        return apartmentInfoService.update(apartmentId, apartmentInfoRequest);
    }
}