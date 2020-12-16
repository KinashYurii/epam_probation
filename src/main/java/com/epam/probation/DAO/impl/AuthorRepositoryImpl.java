package com.epam.probation.DAO.impl;

import com.epam.probation.DAO.AuthorDAO;
import com.epam.probation.model.Author;
import com.epam.probation.model.Book;
import com.epam.probation.model.mapper.AuthorMapper;
import com.epam.probation.model.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorDAO {

    private final JdbcTemplate jdbcTemplate;

    public final static RowMapper<Book> bookRowMapper = new BookMapper();
    public final static RowMapper<Author> authorRowMapper = new AuthorMapper();

    @Override
    public int save(Author author) {
        return jdbcTemplate.update(
                "insert into author (name, age) values(?,?)",
                author.getName(), author.getAge());
    }


    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete author where id = ?", id);
    }

    @Override
    public List<Author> findAll() {
        return jdbcTemplate.query(
                "select * from author",
                (rs, rowNum) -> Author.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("author_name"))
                        .build()
        );
    }

    @Override
    public Author findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from author where id = ?",
                new AuthorMapper());
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select author_name from author where id = ?",
                String.class,
                id);
    }
}
