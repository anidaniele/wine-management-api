package org.example.winemanagementapi.mappers;

import org.example.winemanagementapi.dto.box.BoxRequest;
import org.example.winemanagementapi.dto.box.BoxResponse;
import org.example.winemanagementapi.dto.box.BoxWineResponse;
import org.example.winemanagementapi.dto.wine.WineResponse;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.entities.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WineMapper.class})
public interface BoxMapper {

    @Mapping(target = "wines", ignore = true)
    @Mapping(target = "id", ignore = true)
    Box boxRequestToBox(BoxRequest boxRequest);

    BoxResponse boxToBoxResponse(Box box);

    @Mapping(target = "wines", source = "wines")
    BoxWineResponse boxToBoxWineResponse(Box box);

    List<WineResponse> winesToWineResponses(List<Wine> wines);


}
