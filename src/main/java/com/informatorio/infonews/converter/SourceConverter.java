package com.informatorio.infonews.converter;

import org.springframework.stereotype.Component;

import com.informatorio.infonews.domain.Source;
import com.informatorio.infonews.dto.SourceDTO;

@Component
public class SourceConverter {
    
    public Source toEntity(SourceDTO sourceDTO) {
        return new Source(
            sourceDTO.getId(),
            sourceDTO.getName(),
            sourceDTO.getCode(),
            sourceDTO.getCreatedAt(),
            sourceDTO.getArticles()
        );
    }

    public SourceDTO toDto(Source source) {
        return new SourceDTO(
            source.getId(),
            source.getName(),
            source.getCode(),
            source.getCreatedAt(),
            source.getArticles()
        );
    }
}
