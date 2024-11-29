package com.metmwah.triviaparty.core.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(String name, String value) {
        super("There is no existing "+ name+  " like '" + value+ "'");
    }
    public NotFoundException(String name, Integer value) {
        super("There is no existing "+ name+  " like '" + value+ "'");
    }
    public NotFoundException(String name, long value) {
        super("There is no existing "+ name+  " like '" + value+ "'");
    }
}
