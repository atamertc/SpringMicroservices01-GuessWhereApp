package com.atamertc.exception;

import lombok.Getter;

@Getter
public class GuessManagerException extends RuntimeException {

    private final ErrorType errorType;

    public GuessManagerException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public GuessManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
