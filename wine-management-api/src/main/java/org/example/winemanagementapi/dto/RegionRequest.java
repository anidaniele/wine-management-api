package org.example.winemanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.exceptions.UniqueField;

@Builder
public record RegionRequest (
    @NotBlank(message = "Region name must not be blank")
    @Size(min = 2, max = 50)
    @UniqueField(entity = Region.class, fieldName = "name", message = "Region already exists")
    String name,
    @NotBlank(message = "Country must not be blank")
    @Size(min = 2, max = 50)
    String country,
    @NotBlank(message = "Description must not be blank")
    @Size(min = 2, max = 255)
    String description
){}
