package org.example.winemanagementapi.mappers;

import org.example.winemanagementapi.dto.BoxRequest;
import org.example.winemanagementapi.dto.BoxResponse;
import org.example.winemanagementapi.dto.BoxWineResponse;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.entities.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WineMapper.class})
public interface BoxMapper {

    BoxMapper INSTANCE = Mappers.getMapper(BoxMapper.class);

    @Mapping(target = "wines", ignore = true)
    @Mapping(target = "id", ignore = true)
    Box boxRequestToBox(BoxRequest boxRequest);

    BoxResponse boxToBoxResponse(Box box);

    @Mapping(target = "wines", source = "wines")
    BoxWineResponse boxToBoxWineResponse(Box box);

    List<WineResponse> winesToWineResponses(List<Wine> wines);


}
