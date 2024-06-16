package org.example.winemanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record WineRequest (
    @NotBlank
    @Size(min = 2, max = 50)
    String title,
    @NotBlank
    @Size(min = 2, max = 50)
    String type,
    @NotNull
    Integer year,
    @NotBlank
    @Size(min = 2, max = 50)
    String regionName,
    @NotEmpty
    @Size(min = 1, max = 50)
    List<String> grapeTitles,
    @NotBlank
    @Size(min = 2, max = 50)
    String boxTitle
){}
