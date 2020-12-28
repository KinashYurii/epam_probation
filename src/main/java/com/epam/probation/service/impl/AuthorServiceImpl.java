package com.epam.probation.service.impl;

import com.epam.probation.DAO.AuthorRepository;
import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.model.Author;
import com.epam.probation.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorDAO;

    public AuthorServiceImpl(AuthorRepository authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public Author getById(Long id) throws AuthorNotFoundException {
        return authorDAO.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public List<Author> getAll() {
        return authorDAO.findAll();
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
