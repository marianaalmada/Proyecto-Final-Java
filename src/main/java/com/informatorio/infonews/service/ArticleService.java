package com.informatorio.infonews.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.informatorio.infonews.converter.ArticleConverter;
import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.dto.CustomPage;
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

    public CustomPage getArticles(
            String keyword,
            int page, 
            int size) {
        Pageable pages = PageRequest.of(page, size);
        Page<Article> articles = articleRepository 
                .findByTitleOrDescription(keyword, pages);
        CustomPage customPage = new CustomPage(
                articleConverter.toDTO(articles.getContent()), 
                articles.getTotalElements(), 
                articles.getTotalPages(), 
                articles.getNumber(), 
                articles.getSize(), 
                articles.getNumberOfElements());
        return customPage;
    }
}
