package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyConfirmedException extends HttpServiceException {
    public EmailAlreadyConfirmedException() {
        super(HttpStatus.FORBIDDEN, "Email is already confirmed");
    }
}
