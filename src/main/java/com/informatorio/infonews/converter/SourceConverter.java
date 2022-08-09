package com.informatorio.infonews.converter;

import java.util.List;
import java.util.stream.Collectors;

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
            sourceDTO.getCreatedAt()
        );
    }

    public SourceDTO toDto(Source source) {
        return new SourceDTO(
            source.getId(),
            source.getName(),
            source.getCode(),
            source.getCreatedAt()
        );
    }

    public List<SourceDTO> toDto(List<Source> sources) {
        List<SourceDTO> sourceDTOs = sources.stream()
                .map(source -> this.toDto(source))
                .collect(Collectors.toList());
        return sourceDTOs;
    }
}
