package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.MESSAGE_NOT_FOUND;

public class MessageFoundException extends ModelNotFoundException {
    public MessageFoundException() {
        super(MESSAGE_NOT_FOUND);
    }
}