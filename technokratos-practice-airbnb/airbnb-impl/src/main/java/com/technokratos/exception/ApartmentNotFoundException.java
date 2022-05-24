package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.APARTMENT_NOT_FOUND;

public class ApartmentNotFoundException extends ModelNotFoundException {

    public ApartmentNotFoundException() {
        super(APARTMENT_NOT_FOUND);
    }
}
