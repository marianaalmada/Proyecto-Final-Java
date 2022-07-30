package com.informatorio.infonews.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Source {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    List<Article> articles = new ArrayList<>();

    public Source() {
    }

    public Source(Long id, String name, String code, LocalDateTime createdAt, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createdAt = createdAt;
        this.articles = articles;
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
        return "Source [code=" + code +
                ", createdAt=" + createdAt + 
                ", id=" + id + 
                ", name=" + name + 
                "]";
    } 
}