package org.example.winemanagementapi.mappers;

import org.example.winemanagementapi.dto.WineRequest;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.entities.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RegionMapper.class, GrapeMapper.class})
public interface WineMapper {
    WineMapper INSTANCE = Mappers.getMapper(WineMapper.class);

    @Mapping(target = "regionName", source = "region.name")
    @Mapping(target = "grapeTitles", source = "grapes", qualifiedByName = "mapGrapesToTitles")
    WineResponse wineToWineResponse(Wine wine);

    @Named("mapGrapesToTitles")
    default List<String> mapGrapesToTitles(List<Grape> grapes) {
        return grapes.stream()
                .map(Grape::getTitle)
                .toList();
    }

    @Mapping(source = "regionName", target = "region.name")
    @Mapping(source = "grapeTitles", target = "grapes")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "box", ignore = true)
    Wine wineRequestToWine(WineRequest wineRequest);

    default String grapeToGrapeTitle(Grape grape) {
        return grape.getTitle();
    }

    default Grape grapeTitleToGrape(String title) {
        Grape grape = new Grape();
        grape.setTitle(title);
        return grape;
    }

    List<String> grapesToGrapeTitles(List<Grape> grapes);

    List<Grape> grapeTitlesToGrapes(List<String> grapeTitles);
}
