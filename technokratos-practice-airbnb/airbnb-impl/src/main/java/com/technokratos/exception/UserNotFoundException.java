package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.USER_NOT_FOUND;

public class UserNotFoundException extends ModelNotFoundException {

    public UserNotFoundException() {
        super(USER_NOT_FOUND);
    }
}
