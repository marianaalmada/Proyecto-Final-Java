package com.informatorio.infonews.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.repository.AuthorRepository;
import com.informatorio.infonews.repository.SourceRepository;

@Component
public class ArticleConverter {

    private AuthorConverter authorConverter;
    private SourceConverter sourceConverter;
    private final AuthorRepository authorRepository;
    private final SourceRepository sourceRepository;
    
    @Autowired
    public ArticleConverter(AuthorConverter authorConverter, SourceConverter sourceConverter, 
            AuthorRepository authorRepository, SourceRepository sourceRepository) {
        this.authorConverter = authorConverter;
        this.sourceConverter = sourceConverter;
        this.authorRepository = authorRepository;
        this.sourceRepository = sourceRepository;
    }

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
            authorConverter.toDto(article.getAuthor()),
            sourceConverter.toDto(article.getSource())
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
            authorRepository.findById(articleDTO.getAuthor().getId()).get(),
            sourceRepository.findById(articleDTO.getAuthor().getId()).get()
        );
    }
}
