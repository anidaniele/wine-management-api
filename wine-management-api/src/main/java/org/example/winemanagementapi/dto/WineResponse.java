package org.example.winemanagementapi.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WineResponse (
    Long id,
    String title,
    String type,
    Integer year,
    String regionName,
    List<String> grapeTitles
){}
