package com.informatorio.infonews.dto;

import java.time.LocalDate;

public class AuthorDTO {
    
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate createdAt;

    public AuthorDTO(Long id, String firstName, String lastName, LocalDate createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    public AuthorDTO() {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    } 

    @Override
    public String toString() {
        return "AuthorDTO [firstName=" + firstName +
                ", id=" + id +
                ", lastName=" + lastName +
                "]";
    }
}
