package com.technokratos.service;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.ApartmentSearchRequest;
import com.technokratos.dto.response.ApartmentResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface ApartmentService {
    ApartmentResponse save(ApartmentRequest apartmentRequest);

    ApartmentResponse get(UUID id);

    Boolean isAvailable(ApartmentSearchRequest searchDto);

    void delete(UUID id, UserDetails userDetails);

    ApartmentResponse update(UUID id, ApartmentRequest apartmentRequest, UserDetails userDetails);
}