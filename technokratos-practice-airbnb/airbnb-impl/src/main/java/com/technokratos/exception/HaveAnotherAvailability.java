package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class HaveAnotherAvailability extends HttpServiceException {
    public HaveAnotherAvailability() {
        super(HttpStatus.NOT_ACCEPTABLE, "already have another Availability");
    }
}
