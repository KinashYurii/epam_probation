package com.epam.probation.service;

import com.epam.probation.model.Book;

import java.util.List;

public interface BookService {
    Book getById(Long id);

    List<Book> getAll();

    Book save(Book book);

    void delete(Long id);
}
