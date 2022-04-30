package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends HttpServiceException {
    public UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Email is already taken");
    }
}
