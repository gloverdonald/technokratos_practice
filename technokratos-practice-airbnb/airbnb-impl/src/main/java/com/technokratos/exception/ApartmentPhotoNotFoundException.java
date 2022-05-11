package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.APARTMENT_PHOTO_NOT_FOUND;

public class ApartmentPhotoNotFoundException extends ModelNotFoundException {

    public ApartmentPhotoNotFoundException() {
        super(APARTMENT_PHOTO_NOT_FOUND);
    }
}
