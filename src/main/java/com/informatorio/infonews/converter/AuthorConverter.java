package com.informatorio.infonews.converter;

import java.util.List;
import java.util.stream.Collectors;

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
            author.getCreatedAt()
        );
    }

    public Author toEntity(AuthorDTO authorDTO) {
        return new Author(
            authorDTO.getId(),
            authorDTO.getFirstName(),
            authorDTO.getLastName()
        );
    }

    public List<AuthorDTO> toDto(List<Author> authors) {
        List<AuthorDTO> authorDTOs = authors.stream()
               .map(author -> this.toDto(author))
               .collect(Collectors.toList());
        return authorDTOs;
    }
}
