package com.metmwah.triviaparty.core.exception;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException() {
        super("The password Or Email is incorrect.");
    }
}
