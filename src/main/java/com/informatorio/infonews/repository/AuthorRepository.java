package com.informatorio.infonews.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.infonews.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    List<Author> findByFullNameContains(String name);

    List<Author> findByCreatedAtAfter(LocalDate date);
}
