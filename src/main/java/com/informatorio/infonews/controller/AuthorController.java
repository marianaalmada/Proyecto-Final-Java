package com.informatorio.infonews.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.infonews.config.IllegalOperationException;
import com.informatorio.infonews.converter.AuthorConverter;
import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.dto.AuthorDTO;
import com.informatorio.infonews.repository.AuthorRepository;
import com.informatorio.infonews.service.AuthorService;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;
    public AuthorService authorService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, 
            AuthorConverter authorConverter,
            AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        Author author = authorConverter.toEntity(authorDTO);
        author.setFullName(author.getFirstName() + " " + author.getLastName());
        authorRepository.save(author);
        return new ResponseEntity<>(authorConverter.toDto(author), HttpStatus.CREATED);
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId) {
        Author author = authorRepository.findById(authorId).get();
        if (author.getArticles().isEmpty()) {
            authorRepository.deleteById(authorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new IllegalOperationException(
                "The entity can't be deleted because it's associated with an Article");
        } 
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<?> modifyAuthor(@PathVariable Long authorId, @RequestBody @Valid AuthorDTO authorDTO) {
        Author author = authorRepository.findById(authorId).get();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setFullName(authorDTO.getFirstName() + " " + authorDTO.getLastName());
        authorRepository.save(author);
        return new ResponseEntity<>(authorConverter.toDto(author), HttpStatus.CREATED);
    }

    @GetMapping("/author")
    public ResponseEntity<?> getAuthor(@RequestParam(defaultValue = "0") int page, 
                    @RequestParam (defaultValue = "5") int size,
                    @RequestParam(required = false) String name,
                    @RequestParam(required = false) String date) {
        if (name != null) {
            return new ResponseEntity<>(authorConverter.toDto(authorService.getAuthorByFullName(name)), HttpStatus.OK);
        }
        if (date != null) {  
            return new ResponseEntity<>(authorConverter.toDto(authorService.getAuthorByCreationDate(date)), HttpStatus.OK);
        }

        return new ResponseEntity<>(authorService.getPageableAuthors(page, size), HttpStatus.OK);
    }
}
