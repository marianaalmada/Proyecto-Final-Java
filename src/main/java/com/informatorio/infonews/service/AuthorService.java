package com.informatorio.infonews.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.informatorio.infonews.converter.AuthorConverter;
import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.repository.AuthorRepository;
import com.informatorio.infonews.util.CustomPage;

@Service
public class AuthorService {
    
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    public CustomPage getPageableAuthors(int page, int size) {
        Pageable pages = PageRequest.of(page, size);
        Page<Author> authors = authorRepository.findAll(pages);
        CustomPage customPage = new CustomPage(authorConverter.toDto(authors.getContent()), 
                authors.getTotalElements(), 
                authors.getTotalPages(), 
                authors.getNumber(), 
                authors.getSize(), 
                authors.getNumberOfElements());
        return customPage;
    }

    public List<Author> getAuthorByFullName(String name) {
        List<Author> authors = authorRepository.findByFullNameContains(name);
        return authors;
    }

    public List<Author> getAuthorByCreationDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Author> authors = authorRepository.findByCreatedAtAfter(localDate);
        return authors;
    }
}
