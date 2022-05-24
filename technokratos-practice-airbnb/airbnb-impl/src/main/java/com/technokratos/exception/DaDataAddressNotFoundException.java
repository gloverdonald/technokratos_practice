package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.DADATA_ADDRESS_NOT_FOUND;

public class DaDataAddressNotFoundException extends ModelNotFoundException {

    public DaDataAddressNotFoundException() {
        super(DADATA_ADDRESS_NOT_FOUND);
    }
}
