package org.example.winemanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WineRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String title;
    @NotBlank
    @Size(min = 2, max = 50)
    private String type;
    @NotNull
    private Integer year;
}
