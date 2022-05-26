package com.technokratos.service;

import com.technokratos.dto.request.ApartmentInfoRequest;
import com.technokratos.dto.response.ApartmentInfoResponse;

import java.util.UUID;

public interface ApartmentInfoService {
    ApartmentInfoResponse create(UUID apartmentId, ApartmentInfoRequest apartmentInfoRequest);

    ApartmentInfoResponse get(UUID apartmentId);

    ApartmentInfoResponse update(UUID apartmentId, ApartmentInfoRequest apartmentInfoRequest);
}