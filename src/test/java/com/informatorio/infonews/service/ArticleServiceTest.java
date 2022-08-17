package com.informatorio.infonews.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.informatorio.infonews.converter.ArticleConverter;
import com.informatorio.infonews.domain.Article;
import com.informatorio.infonews.dto.ArticleDTO;
import com.informatorio.infonews.repository.ArticleRepository;
import com.informatorio.infonews.repository.AuthorRepository;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;
    @Mock
    private ArticleConverter articleConverter;
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private ArticleService articleService;

    @Test
    void when_articleDto_is_passed_create_new_article() {
        ArticleDTO articleDto = new ArticleDTO(1L ,"Test", null, 
        null, null, null, "Este es el contenido", 
        true, null, null);

        Article article = new Article(
            1L ,"Test", null, null, null, null, 
            "Este es el contenido", true, null, null);

        when(articleConverter.toEntity(articleDto)).thenReturn(article);
        when(articleRepository.save(article)).thenReturn(article);
        
        assertNotNull(articleService.createArticle(articleDto));
        assertSame(article, articleService.createArticle(articleDto));
    }
}
