package org.example.winemanagementapi.dto.grape;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record GrapeRequest (
    @NotBlank(message = "Title must not be blank")
    @Size(min = 2, max = 50)
    String title,
    @NotBlank(message = "Type must not be blank")
    @Size(min = 2, max = 50)
    String type,
    @NotBlank(message = "Description must not be blank")
    @Size(min = 2, max = 255)
    String description
){}
