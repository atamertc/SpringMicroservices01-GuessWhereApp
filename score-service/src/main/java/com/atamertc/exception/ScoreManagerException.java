package com.atamertc.exception;

import lombok.Getter;

@Getter
public class ScoreManagerException extends RuntimeException {

    private final ErrorType errorType;

    public ScoreManagerException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ScoreManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
