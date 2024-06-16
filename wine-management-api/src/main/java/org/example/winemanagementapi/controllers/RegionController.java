package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.RegionConverter;
import org.example.winemanagementapi.dto.RegionRequest;
import org.example.winemanagementapi.dto.RegionResponse;
import org.example.winemanagementapi.dto.RegionWineResponse;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.exceptions.ConflictException;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.services.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<RegionResponse>> getAllRegions() {
        List<Region> regions = this.regionService.getAllRegions();
        if (regions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(RegionConverter.convertRegionsToRegionResponseList(regions));
    }

//    @GetMapping
//    public ResponseEntity<List<RegionWineResponse>> getAllRegions() {
//        List<Region> regions = this.regionService.getAllRegions();
//        if (regions.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(RegionConverter.convertRegionsToRegionWineResponseList(regions));
//    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/name/{name}")
    public ResponseEntity<RegionWineResponse> getRegionByName(@PathVariable String name) {
        Region region = this.regionService.getRegionByName(name);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RegionConverter.convertRegiontoRegionWineResponse(region));
    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
//    @GetMapping("/country/{country}")
//    public ResponseEntity<List<RegionWineResponse>> getRegionByCountry(@PathVariable String country) {
//        List<Region> region = this.regionService.getRegionsByCountry(country);
//        if (region == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(RegionConverter.convertRegionsToRegionWineResponseList(region));
//    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RegionResponse> createRegion(@RequestBody @Valid RegionRequest regionRequest) {
        Region region = this.regionService.addRegion(RegionConverter.convertRegionRequestToRegion(regionRequest));
        RegionResponse response = RegionConverter.convertRegiontoRegionResponse(region);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegionById(@PathVariable Long id) {
        int result = this.regionService.deleteRegionById(id);
        if (result > 0) {
            return ResponseEntity.noContent().build();
        } else if (result == 0) {
            throw new ResourceNotFoundException("Region not found with id " + id);
        } else {
            throw new ConflictException("Region cannot be deleted - it has associated wines to it");
        }
    }
}
