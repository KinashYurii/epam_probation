package com.epam.probation.exception;

public class AuthorNotFoundException extends Exception {

    public AuthorNotFoundException(Long id) {
        super(String.format("Author not found with id %d", id));
    }
}
