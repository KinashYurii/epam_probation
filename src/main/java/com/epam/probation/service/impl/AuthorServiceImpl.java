package com.epam.probation.service.impl;

import com.epam.probation.DAO.AuthorRepository;
import com.epam.probation.exception.AuthorNotFoundException;
import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.entity.Author;
import com.epam.probation.model.mapper.AuthorMapper;
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
    public AuthorDTO getById(Long id) throws AuthorNotFoundException {
        return AuthorMapper.modelToDTO(
                authorDAO.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author", id)));
    }

    @Override
    public List<AuthorDTO> getAll() {
        return AuthorMapper.modelsToDTOs(authorDAO.findAll());
    }

    @Override
    public AuthorDTO save(Author author) {
        author.getBooks().forEach(book -> book.setAuthor(author));
        authorDAO.save(author);
        return AuthorMapper.modelToDTO(author);
    }

    @Override
    public void delete(Long id) {
        authorDAO.deleteById(id);
    }
}
