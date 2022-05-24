package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.APARTMENT_INFO_NOT_FOUND;

public class ApartmentInfoNotFoundException extends ModelNotFoundException {
    public ApartmentInfoNotFoundException() {
        super(APARTMENT_INFO_NOT_FOUND);
    }
}