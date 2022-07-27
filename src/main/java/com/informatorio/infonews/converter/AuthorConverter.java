package com.informatorio.infonews.converter;

import org.springframework.stereotype.Component;

import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.dto.AuthorDTO;

@Component
public class AuthorConverter {
    
    public AuthorDTO toDto(Author author) {
        return new AuthorDTO(
            author.getId(),
            author.getFirstName(),
            author.getLastName(),
            author.getFullName(),
            author.getCreatedAt(),
            author.getArticles()
        );
    }

    public Author toEntity(AuthorDTO authorDTO) {
        return new Author(
            authorDTO.getId(),
            authorDTO.getFirstName(),
            authorDTO.getLastName(),
            authorDTO.getFullName(),
            authorDTO.getCreatedAt(), 
            authorDTO.getArticles()
        );
    }
}
