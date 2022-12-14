package com.technokratos.service;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.model.ApartmentEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface ApartmentService {
    ApartmentResponse save(ApartmentRequest apartmentRequest, UserDetails userDetails);

    ApartmentResponse get(UUID id);

    void delete(UUID id, UserDetails userDetails);

    ApartmentResponse update(UUID id, ApartmentRequest apartmentRequest, UserDetails userDetails);

    List<ApartmentResponse> getAll(Specification<ApartmentEntity> specification);
}