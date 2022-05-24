package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class PhotoIsEmptyException extends HttpServiceException{

    public PhotoIsEmptyException(){
        super(HttpStatus.BAD_REQUEST, "Photo Is Not Selected");
    }
}
