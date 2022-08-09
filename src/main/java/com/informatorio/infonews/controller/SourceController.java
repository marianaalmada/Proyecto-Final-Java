package com.informatorio.infonews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> createSource(@RequestBody SourceDTO sourceDTO) {
        Source source = sourceConverter.toEntity(sourceDTO);
        String code = source.getName().toLowerCase().replace(" ", "-");
        source.setCode(code);
        sourceRepository.save(source);
        return new ResponseEntity<>(sourceConverter.toDto(source), HttpStatus.CREATED);
    }

    /*@PutMapping("/source/")*/
}
