package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class EmailNotSendException extends HttpServiceException {
    public EmailNotSendException() {
        super(HttpStatus.REQUEST_TIMEOUT, "Failed to register");
    }
}
