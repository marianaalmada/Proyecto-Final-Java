package com.informatorio.infonews.converter;

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
            article.getContent()
        );
    }

    public Article toEntity(ArticleDTO articleDTO) {
        return new Article(
            articleDTO.getId(),
            articleDTO.getTitle(),
            articleDTO.getDescription(),
            articleDTO.getUrl(),
            articleDTO.getUrlToImage(),
            articleDTO.getPublishedAt(),
            articleDTO.getContent()
        );
    }
}
