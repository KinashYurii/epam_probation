package com.epam.probation.service;

import com.epam.probation.exception.BookNotFoundException;
import com.epam.probation.model.DTO.BookDTO;
import com.epam.probation.model.entity.Book;

import java.util.List;

public interface BookService {
    BookDTO getById(Long id) throws BookNotFoundException;

    List<BookDTO> getAll();

    BookDTO save(Book book);

    void delete(Long id);
}
