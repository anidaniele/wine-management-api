package org.example.winemanagementapi.dto.grape;

import lombok.Builder;

@Builder
public record GrapeResponse (
    Long id,
    String title,
    String type,
    String description
){}
