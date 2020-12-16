package com.epam.probation.controller;

import com.epam.probation.model.Book;
import com.epam.probation.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public Book getBook(@RequestParam("id") Long id) {
        return bookService.getById(id);
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@RequestParam("id") Long id) {
        bookService.delete(id);
    }
}
