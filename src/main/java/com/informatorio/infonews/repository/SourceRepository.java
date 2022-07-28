package com.informatorio.infonews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.infonews.domain.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long>{
    
}
