package com.technokratos.controller;

import com.technokratos.api.ReviewApi;
import com.technokratos.dto.request.ApartmentReviewRequest;
import com.technokratos.dto.response.ApartmentReviewResponse;
import com.technokratos.service.ApartmentReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ReviewController implements ReviewApi<UserDetails>  {
    private final ApartmentReviewService apartmentReviewService;

    @Override
    public ApartmentReviewResponse createApartmentReview(UUID apartmentId,
                                                         ApartmentReviewRequest reviewRequest,
                                                         UserDetails userDetails) {
        return apartmentReviewService.create(apartmentId, reviewRequest, userDetails);
    }

    @Override
    public List<ApartmentReviewResponse> getReviewByApartment(UUID apartmentId) {
        return apartmentReviewService.getReviewByApartment(apartmentId);
    }

    @Override
    public ApartmentReviewResponse updateReviewByApartment(UUID reviewId,
                                                           ApartmentReviewRequest reviewRequest,
                                                           UserDetails userDetails) {
        return apartmentReviewService.updateReviewByApartment(reviewId, reviewRequest, userDetails);
    }
}
