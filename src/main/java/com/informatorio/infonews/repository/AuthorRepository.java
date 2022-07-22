package com.informatorio.infonews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.infonews.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
