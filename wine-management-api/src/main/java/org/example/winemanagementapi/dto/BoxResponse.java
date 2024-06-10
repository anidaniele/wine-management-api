package org.example.winemanagementapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoxResponse {
    private Long id;
    private String name;
    private List<WineResponse> wines;
}
