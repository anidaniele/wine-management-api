package org.example.winemanagementapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record RegionResponse (
    Long id,
    String name,
    String country,
    String description
){}
