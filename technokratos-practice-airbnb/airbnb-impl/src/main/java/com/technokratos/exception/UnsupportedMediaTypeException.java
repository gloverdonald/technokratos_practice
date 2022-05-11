package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class UnsupportedMediaTypeException extends HttpServiceException {

    public UnsupportedMediaTypeException() {
        super(HttpStatus.BAD_REQUEST, "Only PNG And JPG Are Supported");
    }
}
