package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class ConfirmEmailException extends HttpServiceException {

    public ConfirmEmailException() {
        super(HttpStatus.FORBIDDEN, "You need to confirm email");
    }
}
