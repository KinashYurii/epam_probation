package com.epam.probation.controller;

import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.mapper.AuthorMapper;
import com.epam.probation.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(@Autowired AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@RequestParam("id") Long id) throws AuthorNotFoundException {
        return authorService.getById(id);
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthor() {
        return authorService.getAll();
    }

    @PostMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.save(AuthorMapper.dtoToModel(authorDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@RequestParam("id") Long id) {
        authorService.delete(id);
    }
}

