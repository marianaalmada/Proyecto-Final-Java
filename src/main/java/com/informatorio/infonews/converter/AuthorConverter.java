package com.informatorio.infonews.converter;

import org.springframework.stereotype.Component;

import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.dto.AuthorDTO;

@Component
public class AuthorConverter {
    
    public AuthorDTO toDto(Author author) {
        return new AuthorDTO(
            author.getFirstName(),
            author.getLastName()
        );
    }

    public Author toEntity(AuthorDTO authorDTO) {
        return new Author(
            authorDTO.getFirstName(),
            authorDTO.getLastName()
        );
    }
}
