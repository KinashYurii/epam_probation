package com.epam.probation.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final String name;

    public UserNotFoundException(String name) {
        this.name = name;
    }
}
