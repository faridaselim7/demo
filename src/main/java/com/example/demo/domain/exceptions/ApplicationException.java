package com.example.demo.domain.exceptions;

public abstract class ApplicationException extends RuntimeException {

    private final String errorCode;
    private final int httpStatus;

    public ApplicationException(String message, String errorCode, int httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}