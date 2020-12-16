package com.epam.probation.DAO;


import com.epam.probation.model.Book;

import java.util.List;

public interface BookDAO {

    int save(Book book);

    int delete(Long id);

    List<Book> findAll();

    Book findById(Long id);

    String getNameById(Long id);
}
