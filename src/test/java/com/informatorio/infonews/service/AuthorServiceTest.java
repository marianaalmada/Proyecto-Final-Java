package com.informatorio.infonews.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.informatorio.infonews.converter.AuthorConverter;
import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.repository.AuthorRepository;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private AuthorConverter authorConverter;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void when_an_existing_name_is_passed_a_list_of_authors_containing_the_name_is_returned() {
        when(authorRepository.findByFullNameContains("Mariana")).thenReturn(
                List.of(new Author(1L, "Mariana", "Almada")));
        
        List<Author> authors = authorService.getAuthorByFullName("Mariana");

        assertNotNull(authors);
        assertIterableEquals(List.of(new Author(1L, "Mariana", "Almada")), authors);
    }

    @Test
    void when_a_non_existing_name_is_passed_an_empty_list_of_authors_is_returned() {
        when(authorRepository.findByFullNameContains("Juan")).thenReturn(
                List.of());
        
        List<Author> authors = authorService.getAuthorByFullName("Juan");

        assertTrue(authors.isEmpty());
        assertIterableEquals(List.of(), authors);
    }
}
