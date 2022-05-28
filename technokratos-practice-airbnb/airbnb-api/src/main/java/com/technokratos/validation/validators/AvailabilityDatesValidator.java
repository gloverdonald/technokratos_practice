package com.technokratos.validation.validators;

import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.validation.annotations.ValidAvailabilityDates;
import com.technokratos.validation.annotations.ValidBookingDates;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AvailabilityDatesValidator implements ConstraintValidator<ValidAvailabilityDates, AvailabilityRequest> {
    @Override
    public void initialize(ValidAvailabilityDates constraintAnnotation) {
    }

    @Override
    public boolean isValid(AvailabilityRequest availabilityRequest, ConstraintValidatorContext context) {
        if (availabilityRequest.getDateFrom() == null || availabilityRequest.getDateTo() == null) {
            return false;
        } else return availabilityRequest.getDateFrom().compareTo(availabilityRequest.getDateTo()) < 0;
    }
}
