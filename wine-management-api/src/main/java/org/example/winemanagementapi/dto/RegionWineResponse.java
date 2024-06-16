package org.example.winemanagementapi.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RegionWineResponse (
    Long id,
    String name,
    String country,
    String description,
    List<WineResponse> wines
){}
