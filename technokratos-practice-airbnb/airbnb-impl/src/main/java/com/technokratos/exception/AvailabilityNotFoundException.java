package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.AVAILABILITY_INFO_NOT_FOUND;

public class AvailabilityNotFoundException extends ModelNotFoundException {
    public AvailabilityNotFoundException() {
        super(AVAILABILITY_INFO_NOT_FOUND);
    }
}
