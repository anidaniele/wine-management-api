package org.example.winemanagementapi.dto.region;

import lombok.Builder;
import org.example.winemanagementapi.dto.wine.WineResponse;

import java.util.List;

@Builder
public record RegionWineResponse (
    Long id,
    String name,
    String country,
    String description,
    List<WineResponse> wines
){}
