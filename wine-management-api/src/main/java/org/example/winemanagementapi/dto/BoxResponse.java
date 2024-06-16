package org.example.winemanagementapi.dto;

import lombok.Builder;

@Builder
public record BoxResponse(
    Long id,
    String name
){}
