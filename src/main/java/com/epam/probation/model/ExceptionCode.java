package com.epam.probation.model;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    NOT_FOUND("not-found");

    private final String value;

    ExceptionCode(String value) {
        this.value = value;
    }
}
