package com.technokratos.validation.validators;

import com.technokratos.dto.request.BookingRequest;
import com.technokratos.validation.annotations.ValidBookingDates;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookingDatesValidator implements ConstraintValidator<ValidBookingDates, BookingRequest> {
    @Override
    public void initialize(ValidBookingDates constraintAnnotation) {
    }

    @Override
    public boolean isValid(BookingRequest bookingRequest, ConstraintValidatorContext context) {
        if (bookingRequest.getDateIn() == null || bookingRequest.getDateOut() == null) {
            return false;
        } else return bookingRequest.getDateIn().compareTo(bookingRequest.getDateOut()) < 0;
    }
}
