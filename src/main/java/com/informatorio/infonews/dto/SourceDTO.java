package com.informatorio.infonews.dto;

import java.time.LocalDateTime;

public class SourceDTO {
    
    private Long id;
    private String name;
    private String code;
    private LocalDateTime createdAt;

    public SourceDTO(Long id, String name, String code, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "SourceDTO [code=" + code +
                ", createdAt=" + createdAt + 
                ", id=" + id + 
                ", name=" + name + 
                "]";
    } 
}
