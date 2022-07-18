package com.informatorio.infonews.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDate publishedAt;
    private String content;
    
    public Article() {
    }

    /*Borrar id del constructor */
    public Article(Long id, String title, String description, String url, String urlToImage, LocalDate publishedAt,
            String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((publishedAt == null) ? 0 : publishedAt.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        result = prime * result + ((urlToImage == null) ? 0 : urlToImage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Article other = (Article) obj;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (publishedAt == null) {
            if (other.publishedAt != null)
                return false;
        } else if (!publishedAt.equals(other.publishedAt))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        if (urlToImage == null) {
            if (other.urlToImage != null)
                return false;
        } else if (!urlToImage.equals(other.urlToImage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Article [content=" + content + 
            ", description=" + description + 
            ", id=" + id + 
            ", publishedAt=" + publishedAt + 
            ", title=" + title + 
            ", url=" + url + 
            ", urlToImage=" + urlToImage + 
            "]";
    }   
}
/*
id (autogenerado) -
title: Representa el titulo -
description: Breve descripcion de la noticia- 
url: Link hacia la pagina de la noticia (ej: https://www.infobae.com/america/ciencia-america/2022/07/12/en-vivo-la-nasa)
urlToImage: Link de la imagen de portada (ej: https://www.infobae.com/new-resizer/4q_cPUh59XY.jpg)
publishedAt: Fecha de publicacion -
content: Texto completo del contenido de la noticia -
Author: Relacion con Author
Source: Relacion con Fuente de la noticia
 */