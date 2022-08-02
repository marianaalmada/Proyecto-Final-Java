package com.informatorio.infonews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.infonews.converter.AuthorConverter;
import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.dto.AuthorDTO;
import com.informatorio.infonews.repository.AuthorRepository;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    @PostMapping("/author")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = authorConverter.toEntity(authorDTO);
        author.setFullName(author.getFirstName() + " " + author.getLastName());
        authorRepository.save(author);
        return new ResponseEntity<>(authorConverter.toDto(author), HttpStatus.CREATED);
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId) {
        authorRepository.deleteById(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<?> modifyAuthor(@PathVariable Long authorId, @RequestBody AuthorDTO authorDTO) {
        Author author = authorRepository.findById(authorId).get();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setFullName(authorDTO.getFirstName() + " " + authorDTO.getLastName());
        authorRepository.save(author);
        return new ResponseEntity<>(authorConverter.toDto(author), HttpStatus.CREATED);
    }
}
