package org.example.winemanagementapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrapeResponse {
    private Long id;
    private String title;
    private String description;
    private List<WineResponse> wines;
}
