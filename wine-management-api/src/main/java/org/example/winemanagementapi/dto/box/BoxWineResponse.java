package org.example.winemanagementapi.dto.box;

import lombok.Builder;
import org.example.winemanagementapi.dto.wine.WineResponse;

import java.util.List;

@Builder
public record BoxWineResponse(
    Long id,
    String name,
    List<WineResponse> wines
){}
