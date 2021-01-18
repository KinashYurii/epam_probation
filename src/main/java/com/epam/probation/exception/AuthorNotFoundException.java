package com.epam.probation.exception;

public class AuthorNotFoundException extends NotFoundException {

    public AuthorNotFoundException(String name, Long id) {
        super(name, id);
    }
}
