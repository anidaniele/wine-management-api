package org.example.winemanagementapi.mappers;

import org.example.winemanagementapi.dto.grape.GrapeRequest;
import org.example.winemanagementapi.dto.grape.GrapeResponse;
import org.example.winemanagementapi.entities.Grape;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GrapeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "wines", ignore = true)
    Grape grapeRequestToGrape(GrapeRequest grapeRequest);

    GrapeResponse grapeToGrapeResponse(Grape grape);
}
