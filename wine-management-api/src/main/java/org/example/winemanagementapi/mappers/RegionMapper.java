package org.example.winemanagementapi.mappers;

import org.example.winemanagementapi.dto.region.RegionRequest;
import org.example.winemanagementapi.dto.region.RegionResponse;
import org.example.winemanagementapi.dto.region.RegionWineResponse;
import org.example.winemanagementapi.dto.wine.WineResponse;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.entities.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = WineMapper.class)
public interface RegionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "wines", ignore = true)
    Region regionRequestToRegion(RegionRequest regionRequest);

    RegionResponse regionToRegionResponse(Region region);

    @Mapping(target = "wines", source = "wines")
    RegionWineResponse regionToRegionWineResponse(Region region);

    List<WineResponse> winesToWineResponses(List<Wine> wines);
}
