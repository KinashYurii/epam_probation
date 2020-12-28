package com.epam.probation.exception;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(Long id) {
        super(String.format("Book not found with id %d", id));
    }
}
