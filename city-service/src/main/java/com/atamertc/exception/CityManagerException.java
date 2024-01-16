package com.atamertc.exception;

import lombok.Getter;

@Getter
public class CityManagerException extends RuntimeException {

    private final ErrorType errorType;

    public CityManagerException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public CityManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
