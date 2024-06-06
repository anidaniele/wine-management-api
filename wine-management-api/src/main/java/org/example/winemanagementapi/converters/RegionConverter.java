package org.example.winemanagementapi.converters;

import org.example.winemanagementapi.dto.RegionRequest;
import org.example.winemanagementapi.entities.Region;

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
}
