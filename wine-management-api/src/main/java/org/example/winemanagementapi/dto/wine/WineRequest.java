package org.example.winemanagementapi.dto.wine;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.util.List;

@Builder
public record WineRequest (
    @NotBlank(message = "Title must not be blank")
    @Size(min = 2, max = 50)
    String title,
    @NotBlank(message = "Type must not be blank")
    @Size(min = 2, max = 50)
    String type,
    @NotNull(message = "Year must not be null")
    @Max(value = 2024, message = "Year cannot be in the future")
    Integer year,
    @NotBlank(message = "Region name must not be blank")
    @Size(min = 2, max = 50)
    String regionName,
    @NotEmpty(message = "Grape titles must not be blank")
    @Size(min = 1, max = 50)
    List<String> grapeTitles,
    @NotBlank(message = "Box title must not be blank")
    @Size(min = 2, max = 50)
    String boxTitle
){}