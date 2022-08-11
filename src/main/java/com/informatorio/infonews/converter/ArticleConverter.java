package com.informatorio.infonews.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;

@Component
public class ArticleConverter {
    
    public ArticleDTO toDTO(Article article) {
        return new ArticleDTO(
            article.getId(),
            article.getTitle(),
            article.getDescription(),
            article.getUrl(),
            article.getUrlToImage(),
            article.getPublishedAt(),
            article.getContent(),
            article.isPublished(),
            article.getAuthor(),
            article.getSource()
        );
    }

    public List<ArticleDTO> toDTO(List<Article> articles) {
        List<ArticleDTO> articlesDT0 = articles.stream()
                .map(article -> this.toDTO(article))
                .collect(Collectors.toList());
        return articlesDT0;
    }

    public Article toEntity(ArticleDTO articleDTO) {
        return new Article(
            articleDTO.getId(),
            articleDTO.getTitle(),
            articleDTO.getDescription(),
            articleDTO.getUrl(),
            articleDTO.getUrlToImage(),
            articleDTO.getPublishedAt(),
            articleDTO.getContent(),
            articleDTO.isPublished(),
            articleDTO.getAuthor(),
            articleDTO.getSource()
        );
    }
}
