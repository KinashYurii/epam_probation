package com.epam.probation.service.impl;

import com.epam.probation.DAO.author.AuthorRepository;
import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.entity.Author;
import com.epam.probation.model.mapper.AuthorMapper;
import com.epam.probation.service.AuthorService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorDAO;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorDAO,
        AuthorMapper authorMapper) {
        this.authorDAO = authorDAO;
        this.authorMapper = authorMapper;
    }

    @Override
    public Author getById(Long id) throws AuthorNotFoundException {
        return authorDAO.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll() {
        return authorMapper.modelsToDtos(authorDAO.findAll());
    }

    @Override
    public Author save(Author author) {
        authorDAO.save(author);
        return author;
    }

    @Override
    public void delete(Long id) {
        authorDAO.deleteById(id);
    }
}
