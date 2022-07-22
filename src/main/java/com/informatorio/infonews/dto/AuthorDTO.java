package com.informatorio.infonews.dto;

import java.time.LocalDateTime;

public class AuthorDTO {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDateTime createdAt;

    public AuthorDTO(Long id, String firstName, String lastName, String fullName, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
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
