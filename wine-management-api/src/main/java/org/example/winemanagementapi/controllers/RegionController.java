package org.example.winemanagementapi.controllers;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.RegionConverter;
import org.example.winemanagementapi.dto.RegionResponse;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.services.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionResponse>> getAllRegions() {
        List<Region> regions = this.regionService.getAllRegions();
        if (regions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(RegionConverter.convertRegionsToRegionResponseList(regions));
    }
}
