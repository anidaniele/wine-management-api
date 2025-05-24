package org.example.winemanagementapi.dto.box;

import lombok.Builder;

@Builder
public record BoxResponse(
    Long id,
    String name
){}
