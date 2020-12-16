package com.epam.probation.DAO;


import com.epam.probation.model.Author;

import java.util.List;

public interface AuthorDAO {

    int save(Author author);

    int delete(Long id);

    List<Author> findAll();

    Author findById(Long id);

    String getNameById(Long id);
}
