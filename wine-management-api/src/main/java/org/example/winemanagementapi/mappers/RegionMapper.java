package org.example.winemanagementapi.mappers;

import org.example.winemanagementapi.dto.RegionRequest;
import org.example.winemanagementapi.dto.RegionResponse;
import org.example.winemanagementapi.dto.RegionWineResponse;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.entities.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = WineMapper.class)
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "wines", ignore = true)
    Region regionRequestToRegion(RegionRequest regionRequest);

    RegionResponse regionToRegionResponse(Region region);

    @Mapping(target = "wines", source = "wines")
    RegionWineResponse regionToRegionWineResponse(Region region);

    List<WineResponse> winesToWineResponses(List<Wine> wines);
}
