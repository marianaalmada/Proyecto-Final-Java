package com.informatorio.infonews.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.informatorio.infonews.domain.Article;

public class AuthorDTO {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDateTime createdAt;
    private List<Article> articles = new ArrayList<>();

    public AuthorDTO(Long id, String firstName, String lastName, String fullName, LocalDateTime createdAt,
            List<Article> articles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        return "AuthorDTO [createdAt=" + createdAt + 
                ", firstName=" + firstName + 
                ", fullName=" + fullName + 
                ", id=" + id + 
                ", lastName=" + lastName + 
                "]";
    }
}
