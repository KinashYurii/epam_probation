package com.epam.probation.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    public Long id;

    public String name;

    public Integer pages;

    public Long authorId;
}
