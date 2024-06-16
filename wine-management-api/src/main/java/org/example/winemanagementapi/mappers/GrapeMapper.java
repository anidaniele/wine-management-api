//package org.example.winemanagementapi.mappers;
//
//import org.example.winemanagementapi.dto.GrapeRequest;
//import org.example.winemanagementapi.dto.GrapeResponse;
//import org.example.winemanagementapi.dto.GrapeWineResponse;
//import org.example.winemanagementapi.entities.Grape;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(componentModel = "spring")
//public interface GrapeMapper {
//
//    GrapeMapper INSTANCE = Mappers.getMapper(GrapeMapper.class);
//
//    GrapeResponse grapeToGrapeResponse(Grape grape);
//
//    Grape grapeRequestToGrape(GrapeRequest grapeRequest);
//
//    @Mapping(source = "wines", target = "wines")
//    GrapeWineResponse grapeToGrapeWineResponse(Grape grape);
//}
