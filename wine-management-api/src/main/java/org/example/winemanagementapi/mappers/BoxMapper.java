//package org.example.winemanagementapi.mappers;
//
//import org.example.winemanagementapi.dto.BoxRequest;
//import org.example.winemanagementapi.dto.BoxResponse;
//import org.example.winemanagementapi.entities.Box;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(componentModel = "spring", uses = {WineMapper.class})
//public interface BoxMapper {
//
//    BoxMapper INSTANCE = Mappers.getMapper(BoxMapper.class);
//
//    @Mapping(target = "wines", ignore = true)
//    Box boxRequestToBox(BoxRequest boxRequest);
//
//    @Mapping(source = "wines", target = "wines")
//    BoxResponse boxToBoxResponse(Box box);
//
//}
