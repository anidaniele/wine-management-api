package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.dto.region.RegionRequest;
import org.example.winemanagementapi.dto.region.RegionResponse;
import org.example.winemanagementapi.dto.region.RegionWineResponse;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.exceptions.ConflictException;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.mappers.RegionMapper;
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
    private final RegionMapper regionMapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<RegionResponse>> getAllRegions() {
        List<Region> regions = this.regionService.getAllRegions();
        if (regions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regions.stream().map(regionMapper::regionToRegionResponse).toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/name/{name}")
    public ResponseEntity<RegionWineResponse> getRegionByName(@PathVariable String name) {
        Region region = this.regionService.getRegionByName(name);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(regionMapper.regionToRegionWineResponse(region));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RegionResponse> createRegion(@RequestBody @Valid RegionRequest regionRequest) {
        Region region = this.regionService.addRegion(regionMapper.regionRequestToRegion(regionRequest));
        RegionResponse response = regionMapper.regionToRegionResponse(region);
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
