package com.company.fitdonation.exception;

public class NoSuchDataException extends RuntimeException {

    public NoSuchDataException() {
        super("No results.");
    }
}
