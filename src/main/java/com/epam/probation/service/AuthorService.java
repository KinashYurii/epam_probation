package com.epam.probation.service;

import com.epam.probation.model.Author;

import java.util.List;

public interface AuthorService {

    Author getById(Long id);

    List<Author> getAll();

    Author save(Author author);

    void delete(Long id);
}
