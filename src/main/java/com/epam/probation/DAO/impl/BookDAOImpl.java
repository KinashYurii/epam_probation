package com.epam.probation.DAO.impl;

import com.epam.probation.DAO.BookDAO;
import com.epam.probation.model.Book;
import com.epam.probation.model.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int save(Book book) {
        return jdbcTemplate.update(
                "insert into books (name, pages) values(?,?)",
                book.getName(), book.getPages());
    }


    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete book where id = ?", id);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(
                "select * from book",
                (rs, rowNum) -> Book.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("book_name"))
                        .pages(rs.getInt("pages"))
                        .build()
        );
    }

    @Override
    public Book findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from book where id = ?",
                new BookMapper());
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select book_name from book where id = ?",
                String.class,
                id);
    }
}
