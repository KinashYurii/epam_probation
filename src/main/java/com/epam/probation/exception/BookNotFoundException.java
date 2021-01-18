package com.epam.probation.exception;

public class BookNotFoundException extends NotFoundException {

    public BookNotFoundException(String name, Long id) {
        super(name, id);
    }
}
