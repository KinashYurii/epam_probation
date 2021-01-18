package com.epam.probation.controller;

import com.epam.probation.configuration.property.ExceptionProperties;
import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.exception.BookNotFoundException;
import com.epam.probation.exception.NotFoundException;
import com.epam.probation.model.DTO.ExceptionDTO;
import com.epam.probation.model.ExceptionCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    private final ExceptionProperties exceptionProperties;

    public RestExceptionHandler(ExceptionProperties exceptionProperties) {
        this.exceptionProperties = exceptionProperties;
    }

    @ResponseBody
    @ExceptionHandler(value = {AuthorNotFoundException.class, BookNotFoundException.class})
    protected ExceptionDTO handleNotFoundException(NotFoundException ex) {
        ExceptionDTO exceptionDTO = exceptionProperties.getExceptionMap().get(ExceptionCode.NOT_FOUND.getValue());
        exceptionDTO.setMessage(String.format(exceptionDTO.getMessage(), ex.getEntityName(), ex.getId()));
        return exceptionDTO;
    }
}
