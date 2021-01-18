package com.epam.probation.model.mapper;

import com.epam.probation.model.DTO.AuthorDTO;
import com.epam.probation.model.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public static Author dtoToModel(AuthorDTO dto) {
        return Author.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .name(dto.getName())
                .books(BookMapper.dtoToModels(dto.getBooks()))
                .build();
    }

    public static AuthorDTO modelToDTO(Author model) {
        return AuthorDTO.builder()
                .id(model.getId())
                .age(model.getAge())
                .name(model.getName())
                .books(BookMapper.modelToDTOs(model.getBooks()))
                .build();
    }

    public static List<AuthorDTO> modelsToDTOs(List<Author> authors) {
        return authors.stream()
                .map(AuthorMapper::modelToDTO)
                .collect(Collectors.toList());
    }
}
