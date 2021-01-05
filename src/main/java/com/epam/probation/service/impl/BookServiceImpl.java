package com.epam.probation.service.impl;

import com.epam.probation.DAO.book.BookRepository;
import com.epam.probation.exception.BookNotFoundException;
import com.epam.probation.model.entity.Book;
import com.epam.probation.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
