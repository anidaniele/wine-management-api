package org.example.winemanagementapi.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.winemanagementapi.dto.RegionRequest;
import org.example.winemanagementapi.dto.RegionResponse;
import org.example.winemanagementapi.dto.RegionWineResponse;
import org.example.winemanagementapi.entities.Region;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class RegionConverter {

    public static Region convertRegionRequestToRegion(RegionRequest regionRequest) {
        Region region = null;
        if (regionRequest != null) {
            region = new Region();
            region.setName(regionRequest.name());
            region.setDescription(regionRequest.description());
            region.setCountry(regionRequest.country());
        }
        return region;
    }

    public static RegionResponse convertRegiontoRegionResponse(Region region) {
        RegionResponse regionResponse = null;
        if (region != null){
            regionResponse = RegionResponse.builder()
                    .id(region.getId())
                    .name(region.getName())
                    .country(region.getCountry())
                    .description(region.getDescription())
                    .build();
        }
        return regionResponse;
     }

    public static List<RegionResponse> convertRegionsToRegionResponseList(List<Region> regions) {
        List<RegionResponse> regionResponses = new ArrayList<>();
        for (Region region : regions) {
            regionResponses.add(convertRegiontoRegionResponse(region));
        }
        return regionResponses;
    }

    public static RegionWineResponse convertRegiontoRegionWineResponse(Region region) {
        RegionWineResponse regionWineResponse = null;
        if (region != null){
            regionWineResponse = RegionWineResponse.builder()
                    .id(region.getId())
                    .name(region.getName())
                    .country(region.getCountry())
                    .description(region.getDescription())
                    .wines(WineConverter.convertWinesToWineResponseList(region.getWines()))
                    .build();
        }
        return regionWineResponse;
    }

    public static List<RegionWineResponse> convertRegionsToRegionWineResponseList(List<Region> regions) {
        List<RegionWineResponse> regionWineResponses = new ArrayList<>();
        for (Region region : regions) {
            regionWineResponses.add(convertRegiontoRegionWineResponse(region));
        }
        return regionWineResponses;
    }
}
