package com.informatorio.infonews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.infonews.converter.ArticleConverter;
import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.service.ArticleService;

@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleConverter articleConverter;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleConverter articleConverter) {
        this.articleService = articleService;
        this.articleConverter = articleConverter;
    }

    @PostMapping("/article")
    public ResponseEntity<?> createArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = articleService.createArticle(articleDTO);
        return new ResponseEntity<>(articleConverter.toDTO(article), HttpStatus.CREATED);
    }

    @GetMapping("/article")
    public ResponseEntity<?> getArticles() {
        List<Article> articles = articleService.getArticles();
        return new ResponseEntity<>(articleConverter.toDTO(articles), HttpStatus.OK);
    }
}
