package com.epam.probation.service.impl;

import com.epam.probation.DAO.AuthorDAO;
import com.epam.probation.model.Author;
import com.epam.probation.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;

    @Override
    public Author getById(Long id) {
        return authorDAO.findById(id);
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
        authorDAO.delete(id);
    }
}
