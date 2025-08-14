package com.example.demo.domain.exceprions;


import com.bank.userservice.application.exceprions.domain.ApplicationException;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super("User not found", "USER_NOT_FOUND", 404);
    }

    public UserNotFoundException(String message, String errorCode, int httpStatus) {
        super(message, errorCode, httpStatus);
    }
}
