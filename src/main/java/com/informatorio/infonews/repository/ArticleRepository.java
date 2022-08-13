package com.informatorio.infonews.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.informatorio.infonews.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT a FROM Article a WHERE a.published = true and a.title LIKE %:keyword% OR a.description LIKE %:keyword%")
    Page<Article> findByTitleOrDescription(@Param("keyword") String keyword, Pageable peagable);
}
