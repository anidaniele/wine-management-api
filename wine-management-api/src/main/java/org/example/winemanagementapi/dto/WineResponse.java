package org.example.winemanagementapi.dto;

import lombok.Data;
import org.example.winemanagementapi.entities.Grape;

import java.util.List;

@Data
public class WineResponse {
    private Long id;
    private String title;
    private String type;
    private Integer year;
    private List<GrapeResponse> grapes;
    private RegionResponse region  ;
}
