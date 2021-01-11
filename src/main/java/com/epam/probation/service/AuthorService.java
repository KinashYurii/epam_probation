package com.epam.probation.service;

import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.entity.Author;

import java.util.List;

public interface AuthorService {

    Author getById(Long id) throws AuthorNotFoundException;

    List<AuthorDTO> getAll();

    Author save(Author author);

    void delete(Long id);
}
