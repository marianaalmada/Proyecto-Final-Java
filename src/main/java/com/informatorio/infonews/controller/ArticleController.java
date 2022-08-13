package com.informatorio.infonews.controller;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.infonews.converter.ArticleConverter;
import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.service.ArticleService;

@RestController
@Validated
public class ArticleController {

    private ArticleService articleService;
    private ArticleConverter articleConverter;

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
    public ResponseEntity<?> getArticles(
            @RequestParam @Size(min = 3) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(articleService.getArticles(keyword, page, size), HttpStatus.OK);
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<?> modifyArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        Article article = articleService.modifyArticle(id, articleDTO);
        return new ResponseEntity<>(articleConverter.toDTO(article), HttpStatus.CREATED);
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
