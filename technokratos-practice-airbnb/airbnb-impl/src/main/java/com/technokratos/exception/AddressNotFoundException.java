package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.ADDRESS_NOT_FOUND;

public class AddressNotFoundException extends ModelNotFoundException {

    public AddressNotFoundException() {
        super(ADDRESS_NOT_FOUND);
    }
}
