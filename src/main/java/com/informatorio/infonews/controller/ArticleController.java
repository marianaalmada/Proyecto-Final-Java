package com.informatorio.infonews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.infonews.converter.ArticleConverter;
import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.repository.ArticleRepository;

@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleConverter articleConverter;

    @Autowired
    public ArticleController(ArticleRepository articleRepository, ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    @PostMapping("/article")
    public ResponseEntity<?> createArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = articleConverter.toEntity(articleDTO);
        articleRepository.save(article);
        return new ResponseEntity<>(articleConverter.toDTO(article), HttpStatus.CREATED);
    }
}
