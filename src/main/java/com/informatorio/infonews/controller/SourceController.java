package com.informatorio.infonews.controller;

import java.util.List;

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
import com.informatorio.infonews.converter.SourceConverter;
import com.informatorio.infonews.domain.Source;
import com.informatorio.infonews.dto.SourceDTO;
import com.informatorio.infonews.repository.SourceRepository;

@RestController
public class SourceController {

    private final SourceRepository sourceRepository;
    private final SourceConverter sourceConverter;
    
    @Autowired
    public SourceController(SourceRepository sourceRepository, SourceConverter sourceConverter) {
        this.sourceRepository = sourceRepository;
        this.sourceConverter = sourceConverter;
    }

    @PostMapping("/source")
    public ResponseEntity<?> createSource(@RequestBody @Valid SourceDTO sourceDTO) {
        Source source = sourceConverter.toEntity(sourceDTO);
        String code = source.getName().toLowerCase().replace(" ", "-");
        source.setCode(code);
        sourceRepository.save(source);
        return new ResponseEntity<>(sourceConverter.toDto(source), HttpStatus.CREATED);
    }

    @PutMapping("/source/{sourceId}")
    public ResponseEntity<?> modifySource(@PathVariable Long sourceId, @RequestBody @Valid SourceDTO sourceDTO) {
        Source source = sourceRepository.findById(sourceId).get();
        source.setName(sourceDTO.getName());
        String code = sourceDTO.getName().toLowerCase().replace(" ", "-");
        source.setCode(code);
        sourceRepository.save(source);
        return new ResponseEntity<>(sourceConverter.toDto(source), HttpStatus.CREATED);
    }

    @GetMapping("/source")
    public ResponseEntity<?> getSources(@RequestParam(required = false) String name) {
        List<Source> sources = sourceRepository.findAll();
        if (name != null) {
            List<Source> sourcesByName = sourceRepository.findByNameContains(name);
            return new ResponseEntity<>(sourceConverter.toDto(sourcesByName), HttpStatus.OK);
        }
        return new ResponseEntity<>(sourceConverter.toDto(sources), HttpStatus.OK);
    }

    @DeleteMapping("/source/{sourceId}")
    public ResponseEntity<?> deleteSource(@PathVariable Long sourceId) throws Exception {
        Source source = sourceRepository.findById(sourceId).get();
        if (source.getArticles().isEmpty()) {
            sourceRepository.deleteById(sourceId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new IllegalOperationException(
                "The entity can't be deleted because it's associated with an Article");
        }  
    }
}