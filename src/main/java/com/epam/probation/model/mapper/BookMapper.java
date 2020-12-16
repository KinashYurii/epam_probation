package com.epam.probation.model.mapper;

import com.epam.probation.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        return Book.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .pages(resultSet.getInt("pages"))
                .build();
    }
}
