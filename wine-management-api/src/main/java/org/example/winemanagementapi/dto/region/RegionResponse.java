package org.example.winemanagementapi.dto.region;

import lombok.Builder;

@Builder
public record RegionResponse (
    Long id,
    String name,
    String country,
    String description
){}
