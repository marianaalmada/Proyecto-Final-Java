package com.informatorio.infonews.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.informatorio.infonews.domain.Article;

public class SourceDTO {
    
    private Long id;
    private String name;
    private String code;
    private LocalDateTime createdAt;
    List<Article> articles = new ArrayList<>();

    public SourceDTO(Long id, String name, String code, LocalDateTime createdAt, List<Article> articles ) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createdAt = createdAt;
        this.articles = articles;
    }

    public SourceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    } 

    @Override
    public String toString() {
        return "SourceDTO [code=" + code +
                ", createdAt=" + createdAt + 
                ", id=" + id + 
                ", name=" + name + 
                "]";
    }
}