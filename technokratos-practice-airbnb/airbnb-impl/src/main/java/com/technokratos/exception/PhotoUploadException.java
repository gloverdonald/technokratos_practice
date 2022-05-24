package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class PhotoUploadException extends HttpServiceException{
    public PhotoUploadException() {
        super(HttpStatus.GATEWAY_TIMEOUT, "Photo Can't Be Uploaded");
    }
}
