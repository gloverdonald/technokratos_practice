package com.technokratos.api;

import com.technokratos.dto.request.ApartmentReviewRequest;
import com.technokratos.dto.response.ApartmentReviewResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments/review")
public interface ReviewApi<PRINCIPAL> {
    @PostMapping("/{apartment-id}")
    ApartmentReviewResponse createApartmentReview(@PathVariable("apartment-id") UUID apartmentId,
                                                  @RequestBody ApartmentReviewRequest reviewRequest,
                                                  @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @GetMapping("/{apartment-id}")
    List<ApartmentReviewResponse> getReviewByApartment(@PathVariable("apartment-id") UUID apartmentId);

    @PutMapping("/{apartment-id}")
    ApartmentReviewResponse updateReviewByApartment(@PathVariable("apartment-id") UUID reviewId,
                                                    @RequestBody ApartmentReviewRequest reviewRequest,
                                                    @AuthenticationPrincipal PRINCIPAL userPrincipal);
}