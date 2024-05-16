package com.aston.frontendpracticeservice.domain.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String massage) {
        super(massage);
    }
}
