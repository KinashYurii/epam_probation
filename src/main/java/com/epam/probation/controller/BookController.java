package com.epam.probation.controller;

import com.epam.probation.exception.BookNotFoundException;
import com.epam.probation.model.Book;
import com.epam.probation.model.DTO.BookDTO;
import com.epam.probation.model.mapper.BookMapper;
import com.epam.probation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(@Autowired BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@RequestParam("id") Long id) throws BookNotFoundException {
        return bookMapper.modelToDTO(bookService.getById(id));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @PostMapping
    public Book saveBook(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookMapper.dtoToModel(bookDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@RequestParam("id") Long id) {
        bookService.delete(id);
    }
}
