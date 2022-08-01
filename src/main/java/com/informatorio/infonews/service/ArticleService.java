package com.informatorio.infonews.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.infonews.converter.ArticleConverter;
import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.repository.ArticleRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleConverter articleConverter;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleConverter.toEntity(articleDTO);
        if (article.isPublished()) {
            article.setPublishedAt(LocalDate.now());
        }
        articleRepository.save(article);
        return articleConverter.toDTO(article);
    }
}
