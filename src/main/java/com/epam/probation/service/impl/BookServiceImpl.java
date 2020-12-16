package com.epam.probation.service.impl;

import com.epam.probation.DAO.BookDAO;
import com.epam.probation.model.Book;
import com.epam.probation.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Override
    public Book getById(Long id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book save(Book book) {
        bookDAO.save(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        bookDAO.delete(id);
    }
}
