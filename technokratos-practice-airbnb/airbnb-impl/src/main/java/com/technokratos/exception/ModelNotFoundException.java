package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class ModelNotFoundException extends HttpServiceException {

    public ModelNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
