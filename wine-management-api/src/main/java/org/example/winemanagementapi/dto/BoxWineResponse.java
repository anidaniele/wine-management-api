package org.example.winemanagementapi.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BoxWineResponse(
    Long id,
    String name,
    List<WineResponse> wines
){}
