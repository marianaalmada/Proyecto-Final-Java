package com.informatorio.infonews.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SourceDTO {
    
    private Long id;
    @NotBlank
    @Size(min = 3, max = 100) 
    private String name;
    private String code;
    private LocalDate createdAt;

    public SourceDTO(Long id, String name, String code, LocalDate createdAt) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
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