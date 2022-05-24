package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.PHOTO_NOT_FOUND;

public class PhotoNotFoundException extends ModelNotFoundException {

    public PhotoNotFoundException() {
        super(PHOTO_NOT_FOUND);
    }
}
