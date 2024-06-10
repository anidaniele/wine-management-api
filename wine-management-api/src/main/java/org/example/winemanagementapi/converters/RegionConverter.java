package org.example.winemanagementapi.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.winemanagementapi.dto.RegionRequest;
import org.example.winemanagementapi.dto.RegionResponse;
import org.example.winemanagementapi.entities.Region;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class RegionConverter {

    public static Region convertRegionRequestToRegion(RegionRequest regionRequest) {
        Region region = null;
        if (regionRequest != null) {
            region = new Region();
            region.setName(regionRequest.getName());
            region.setDescription(regionRequest.getDescription());
            region.setCountry(regionRequest.getCountry());
        }
        return region;
    }

    public static RegionResponse convertRegiontoRegionResponse(Region region) {
        RegionResponse regionResponse = null;
        if (region != null){
            regionResponse = new RegionResponse();
            regionResponse.setId(region.getId());
            regionResponse.setName(region.getName());
            regionResponse.setCountry(region.getCountry());
            regionResponse.setDescription(region.getDescription());
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
}
