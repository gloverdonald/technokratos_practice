package com.technokratos.service;

import com.technokratos.dto.request.ApartmentReviewRequest;
import com.technokratos.dto.response.ApartmentReviewResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface ApartmentReviewService {

    ApartmentReviewResponse create(UUID apartmentId, ApartmentReviewRequest reviewRequest, UserDetails userDetails);

    List<ApartmentReviewResponse> getReviewByApartment(UUID apartmentId);

    ApartmentReviewResponse updateReviewByApartment(UUID reviewId, ApartmentReviewRequest reviewRequest, UserDetails userDetails);
}
