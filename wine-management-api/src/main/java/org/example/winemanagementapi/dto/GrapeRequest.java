package org.example.winemanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
public record GrapeRequest (
    @NotBlank
    @Size(min = 2, max = 50)
    String title,
    @NotBlank
    @Size(min = 2, max = 50)
    String type,
    @NotBlank
    @Size(min = 2, max = 255)
    String description
){}
