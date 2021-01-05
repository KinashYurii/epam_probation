package com.epam.probation.service;

import com.epam.probation.exception.BookNotFoundException;
import com.epam.probation.model.entity.Book;

import java.util.List;

public interface BookService {
    Book getById(Long id) throws BookNotFoundException;

    List<Book> getAll();

    Book save(Book book);

    void delete(Long id);
}
