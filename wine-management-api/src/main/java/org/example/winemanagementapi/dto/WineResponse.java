package org.example.winemanagementapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class WineResponse {
    private Long id;
    private String title;
    private String type;
    private Integer year;
    //@JsonIgnore
    private List<GrapeResponse> grapes;
    private RegionResponse region;
}
