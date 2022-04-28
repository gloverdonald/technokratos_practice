package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.ROLE_NOT_FOUND;

public class RoleNotFoundException extends ModelNotFoundException {

    public RoleNotFoundException() {
        super(ROLE_NOT_FOUND);
    }
}
