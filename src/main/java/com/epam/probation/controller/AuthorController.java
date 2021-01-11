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
    private final AuthorMapper authorMapper;

    public AuthorController(@Autowired AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@RequestParam("id") Long id) throws AuthorNotFoundException {
        return authorMapper.modelToDTO(authorService.getById(id));
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthor() {
        return authorService.getAll();
    }

    @PostMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorMapper.modelToDTO(authorService.save(authorMapper.dtoToModel(authorDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@RequestParam("id") Long id) {
        authorService.delete(id);
    }
}

