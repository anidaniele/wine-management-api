package org.example.winemanagementapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record GrapeResponse (
    Long id,
    String title,
    String type,
    String description
){}
