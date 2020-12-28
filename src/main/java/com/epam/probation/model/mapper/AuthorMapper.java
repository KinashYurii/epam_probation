package com.epam.probation.model.mapper;

import com.epam.probation.model.Author;
import com.epam.probation.model.DTO.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author dtoToModel(AuthorDTO dto) {
        return Author.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .name(dto.getName())
                .books(dto.getBooks())
                .build();
    }

    public AuthorDTO modelToDTO(Author model) {
        return AuthorDTO.builder()
                .id(model.getId())
                .age(model.getAge())
                .name(model.getName())
                .books(model.getBooks())
                .build();
    }
}
