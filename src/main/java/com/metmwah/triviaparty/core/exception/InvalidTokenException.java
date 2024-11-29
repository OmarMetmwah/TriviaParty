package com.metmwah.triviaparty.core.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("Token is invalid");
    }
}
