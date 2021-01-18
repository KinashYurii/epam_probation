package com.epam.probation.service;

import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.entity.Author;

import java.util.List;

public interface AuthorService {

    AuthorDTO getById(Long id) throws AuthorNotFoundException;

    List<AuthorDTO> getAll();

    AuthorDTO save(Author author);

    void delete(Long id);
}
