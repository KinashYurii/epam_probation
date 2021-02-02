package com.epam.probation.controller;

import com.epam.probation.DAO.AuthorRepository;
import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestExceptionHandlerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private AuthorRepository authorDAO;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private RestExceptionHandler exceptionHandler;

    @Test
    public void authorNotFound() {
        when(authorDAO.findById(5L)).thenThrow(AuthorNotFoundException.class);
        Assertions.assertThrows(AuthorNotFoundException.class, () ->
                authorService.getById(5L));

        verify(authorDAO, times(1)).findById(any());


    }
}