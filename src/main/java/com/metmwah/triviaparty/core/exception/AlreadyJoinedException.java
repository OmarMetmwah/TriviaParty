package com.metmwah.triviaparty.core.exception;

public class AlreadyJoinedException extends RuntimeException {
    public AlreadyJoinedException() {
        super("You have already joined this game");
    }
}
