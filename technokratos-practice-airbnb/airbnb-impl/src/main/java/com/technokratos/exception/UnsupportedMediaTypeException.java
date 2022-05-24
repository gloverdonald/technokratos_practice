package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class UnsupportedMediaTypeException extends HttpServiceException {

    public UnsupportedMediaTypeException() {
        super(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Only PNG And JPG Are Supported");
    }
}
