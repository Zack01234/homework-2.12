package com.example.homework2_12.service.exception;

public class DivideOnZeroException extends IllegalArgumentException {
    public DivideOnZeroException() {
    }

    public DivideOnZeroException(String i) {
        super(i);
    }

    public DivideOnZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivideOnZeroException(Throwable cause) {
        super(cause);
    }
}
