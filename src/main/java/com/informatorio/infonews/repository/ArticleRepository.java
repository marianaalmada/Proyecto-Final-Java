package com.informatorio.infonews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.infonews.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
    List<Article> findByPublishedTrue();
}
