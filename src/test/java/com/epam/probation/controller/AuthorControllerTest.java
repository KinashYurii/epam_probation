package com.epam.probation.controller;

import com.epam.probation.DAO.author.AuthorRepository;
import com.epam.probation.model.entity.Author;
import com.epam.probation.model.entity.Book;
import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.mapper.AuthorMapper;
import com.epam.probation.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorMapper authorMapper;

    @MockBean
    private AuthorRepository authorDAO;


    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        final String getAllURL = "http://localhost:" + port + "/author";

        when(authorDAO.findAll()).thenReturn(getDefaultAuthorList());
        ResponseEntity<AuthorDTO[]> response = restTemplate.getForEntity(getAllURL, AuthorDTO[].class);
        List<AuthorDTO> authors = Arrays.asList(Objects.requireNonNull(response.getBody()));
        assertEquals(authors.size(),2);
        assertEquals(authors.get(0).getBooks().size(),1);
        assertEquals(authors.get(1).getBooks().size(),2);
    }

    private List<Author> getDefaultAuthorList() {
        List<Book> oneBook = List.of(
                buildBook(1L, "Book1", 31)
        );
        List<Book> twoBook = List.of(
                buildBook(2L, "Book2", 35),
                buildBook(3L, "Book3", 391));
        return List.of(
                buildAuthor(1L, oneBook, "Petro", 23),
                buildAuthor(2L, twoBook, "Ivan", 47)
        );
    }

    private Author buildAuthor(Long id, List<Book> books, String name, Integer age) {
        return Author.builder()
                .id(id)
                .books(books)
                .name(name)
                .age(age)
                .build();
    }

    private Book buildBook(Long id, String name, Integer pages) {
        return Book.builder()
                .id(id)
                .name(name)
                .pages(pages)
                .build();
    }
}