package com.informatorio.infonews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.service.ArticleService;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/article")
    public ResponseEntity<?> createArticle(@RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<>(articleService.createArticle(articleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/article")
    public ResponseEntity<?> getArticles() {
        return new ResponseEntity<>(articleService.getArticles(), HttpStatus.OK);
    }
}
