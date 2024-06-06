package org.example.winemanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoxRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
}
