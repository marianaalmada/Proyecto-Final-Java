package com.informatorio.infonews.service;

import java.time.LocalDate;
import java.util.List;

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

    public Article createArticle(ArticleDTO articleDTO) {
        Article article = articleConverter.toEntity(articleDTO);
        if (article.isPublished()) {
            article.setPublishedAt(LocalDate.now());
        }
        return articleRepository.save(article);
    }

    public List<Article> getArticles() {
        List<Article> articles = articleRepository.findByPublishedTrue();
        return articles;
    }
}
