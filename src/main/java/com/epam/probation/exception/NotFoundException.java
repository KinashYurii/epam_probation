package com.epam.probation.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String entityName;
    private final Long id;

    public NotFoundException(String entityName, Long id) {
        super();
        this.entityName = entityName;
        this.id = id;
    }
}
