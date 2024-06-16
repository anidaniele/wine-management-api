//package org.example.winemanagementapi.controllers;
//
//import lombok.RequiredArgsConstructor;
//
//import org.example.winemanagementapi.dto.RegionResponse;
//import org.example.winemanagementapi.dto.RegionWineResponse;
//import org.example.winemanagementapi.entities.Region;
//import org.example.winemanagementapi.mappers.RegionMapper;
//import org.example.winemanagementapi.services.RegionService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/regions")
//public class RegionController {
//
//    private final RegionService regionService;
//    private final RegionMapper regionMapper;
//
//    @GetMapping
//    public ResponseEntity<List<RegionResponse>> getAllRegions() {
//        List<Region> regions = this.regionService.getAllRegions();
//        if (regions.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(regions.stream().map(regionMapper::regionToRegionResponse).toList());
//    }
//
//}
