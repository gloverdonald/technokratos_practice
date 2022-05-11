package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class PhotoDownloadException extends HttpServiceException {

    public PhotoDownloadException() {
        super(HttpStatus.GATEWAY_TIMEOUT, "Photo Can't Be Downloaded");
    }
}