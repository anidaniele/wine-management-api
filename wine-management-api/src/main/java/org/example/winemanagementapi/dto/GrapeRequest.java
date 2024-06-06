package org.example.winemanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GrapeRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String title;
    @NotBlank
    @Size(min = 2, max = 255)
    private String description;
}
