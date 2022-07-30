package com.informatorio.infonews.dto;

import java.time.LocalDate;

import com.informatorio.infonews.domain.Author;
import com.informatorio.infonews.domain.Source;

public class ArticleDTO {
    
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDate publishedAt;
    private String content;
    private Author author; 
    private Source source;
    
    public ArticleDTO(Long id, String title, String description, String url, String urlToImage, 
            LocalDate publishedAt, String content, Author author, Source source) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.author = author;
        this.source = source;
    }

    public ArticleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
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
        ArticleDTO other = (ArticleDTO) obj;
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
        return "ArticleDTO [content=" + content + 
            ", description=" + description + 
            ", id=" + id + 
            ", publishedAt=" + publishedAt + 
            ", title=" + title + 
            ", url=" + url + 
            ", urlToImage=" + urlToImage + 
            "]";
    }
}
