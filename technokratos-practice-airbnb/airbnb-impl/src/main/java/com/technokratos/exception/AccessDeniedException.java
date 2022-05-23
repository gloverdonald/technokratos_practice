package com.technokratos.exception;

import org.springframework.http.HttpStatus;

import static com.technokratos.exception.MessageConstants.ACCESS_DENIED;

public class AccessDeniedException extends HttpServiceException {
    public AccessDeniedException() {
        super(HttpStatus.FORBIDDEN, ACCESS_DENIED);
    }
}