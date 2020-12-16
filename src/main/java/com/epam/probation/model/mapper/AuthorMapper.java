package com.epam.probation.model.mapper;

import com.epam.probation.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

//    Long id = rs.getLong("id");
//    String name = rs.getString("name");
//    String email = rs.getString("email");
//    Person person = personsById.get(id);
//    if (person == null) {
//        person = new Person(id, name);
//        personsById.put(person.getId(), person);
//    }
//    person.addEmail(email);

    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        return Author.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("author_name"))
                .age(resultSet.getInt("age"))
                .build();
    }
}
