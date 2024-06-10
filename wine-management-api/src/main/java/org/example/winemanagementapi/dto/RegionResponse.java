package org.example.winemanagementapi.dto;

import lombok.Data;

@Data
public class RegionResponse {
    private Long id;
    private String name;
    private String country;
    private String description;
}
