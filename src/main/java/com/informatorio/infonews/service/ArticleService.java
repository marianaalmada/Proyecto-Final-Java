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
import com.informatorio.infonews.repository.AuthorRepository;
import com.informatorio.infonews.repository.SourceRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleConverter articleConverter;
    private final AuthorRepository authorRepository;
    private final SourceRepository sourceRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, 
            ArticleConverter articleConverter, AuthorRepository authorRepository, 
            SourceRepository sourceRepository) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
        this.authorRepository = authorRepository;
        this.sourceRepository = sourceRepository;
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

    public Article modifyArticle(Long id, ArticleDTO articleDTO) {
        Article article = articleRepository.findById(id).get();
        article.setTitle(articleDTO.getTitle());
        article.setDescription(articleDTO.getDescription());
        article.setUrl(articleDTO.getUrl());
        article.setUrlToImage(articleDTO.getUrlToImage());
        article.setContent(articleDTO.getContent());
        article.setPublished(articleDTO.isPublished());
        article.setAuthor(authorRepository.findById(articleDTO.getAuthor().getId()).get());
        article.setSource(sourceRepository.findById(articleDTO.getSource().getId()).get());
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
