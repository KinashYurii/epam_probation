package com.epam.probation.model.mapper;

import com.epam.probation.model.Author;
import com.epam.probation.model.DTO.AuthorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<AuthorDTO> modelsToDtos(List<Author> authors) {
        return authors.stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }
}
