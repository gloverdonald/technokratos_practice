package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.APARTMENT_REVIEW_NOT_FOUND;

public class ApartmentReviewNotFoundException extends ModelNotFoundException {
    public ApartmentReviewNotFoundException() {
        super(APARTMENT_REVIEW_NOT_FOUND);
    }
}