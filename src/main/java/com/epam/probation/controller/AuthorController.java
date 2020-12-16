package com.epam.probation.controller;

import com.epam.probation.model.Author;
import com.epam.probation.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public Author getAuthor(@RequestParam("id") Long id) {
        return authorService.getById(id);
    }


    @GetMapping
    public List<Author> getAllAuthor() {
        return authorService.getAll();
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@RequestParam("id") Long id) {
        authorService.delete(id);
    }
}

