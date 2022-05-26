package com.technokratos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentReviewResponse {
    private UUID id;

    private Integer rating;

    private String comment;

    private ApartmentResponse apartment;

    private Boolean deleted;
}
