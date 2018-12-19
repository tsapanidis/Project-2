package com.jp2.exceptions;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException() {
    }

    @Override
    public String getMessage() {
        return "This Owner Doesn't exist!!!";
    }
}
