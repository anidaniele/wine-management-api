//package org.example.winemanagementapi.mappers;
//
//import org.example.winemanagementapi.dto.RegionRequest;
//import org.example.winemanagementapi.dto.RegionResponse;
//import org.example.winemanagementapi.dto.RegionWineResponse;
//import org.example.winemanagementapi.entities.Region;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(componentModel = "spring")
//public interface RegionMapper {
//    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);
//
//    RegionResponse regionToRegionResponse(Region region);
//
//    Region regionRequestToRegion(RegionRequest regionRequest);
//
//    @Mapping(source = "wines", target = "wines")
//    RegionWineResponse regionToRegionWineResponse(Region region);
//}
