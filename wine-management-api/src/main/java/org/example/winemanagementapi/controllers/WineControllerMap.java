package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.dto.WineRequest;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.entities.Wine;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.mappers.WineMapper;
import org.example.winemanagementapi.services.BoxService;
import org.example.winemanagementapi.services.GrapeService;
import org.example.winemanagementapi.services.RegionService;
import org.example.winemanagementapi.services.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wines")
public class WineControllerMap {
    private final WineService wineService;
    private final GrapeService grapeService;
    private final RegionService regionService;
    private final BoxService boxService;
    private final WineMapper wineMapper;


    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<WineResponse>> getAllWines() {
        List<Wine> wines = this.wineService.getAllWines();
        if (wines.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(wines.stream().map(wineMapper::wineToWineResponse).toList());
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<WineResponse> addWine(@RequestBody @Valid WineRequest wineRequest) {
        Wine wine = wineMapper.wineRequestToWine(wineRequest);
        List<Grape> grapes = this.grapeService.getGrapesByTitle(wineRequest.grapeTitles());
        if (grapes.size() != wineRequest.grapeTitles().size()){
            return ResponseEntity.notFound().build();
        }
        Region region = this.regionService.getRegionByName(wineRequest.regionName());
        Box box = this.boxService.getBoxByName(wineRequest.boxTitle());
        wine.setRegion(region);
        wine.setBox(box);
        wine.setGrapes(grapes);
        Wine addedWine = this.wineService.addWine(wine);
        WineResponse response = wineMapper.wineToWineResponse(addedWine);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/country/{country}")
    public ResponseEntity<List<WineResponse>> getAllWinesByCountry(@PathVariable String country) {
        try {
            List<Wine> wines = wineService.getWinesByCountry(country);
            if (wines.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            List<WineResponse> wineResponses = wines.stream().map(wineMapper::wineToWineResponse).toList();
            return ResponseEntity.ok(wineResponses);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/region/{region}")
    public ResponseEntity<List<WineResponse>> getAllWinesByRegion(@PathVariable String region) {
        List<Wine> wines = this.wineService.getWinesByRegionName(region);
        if (wines.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(wines.stream().map(wineMapper::wineToWineResponse).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WineResponse> updateWine(@PathVariable Long id, @RequestBody @Valid WineRequest wineUpdateRequest) {
        Wine wine = this.wineService.getWineById(id);
        if (wine == null) {
            return ResponseEntity.notFound().build();
        }

        List<Grape> grapes = this.grapeService.getGrapesByTitle(wineUpdateRequest.grapeTitles());
        if (grapes.size() != wineUpdateRequest.grapeTitles().size()) {
            return ResponseEntity.notFound().build();
        }

        Region region = this.regionService.getRegionByName(wineUpdateRequest.regionName());
        Box box = this.boxService.getBoxByName(wineUpdateRequest.boxTitle());

        wine.setTitle(wineUpdateRequest.title());
        wine.setType(wineUpdateRequest.type());
        wine.setYear(wineUpdateRequest.year());
        wine.setRegion(region);
        wine.setBox(box);
        wine.setGrapes(grapes);

        Wine updatedWine = this.wineService.addWine(wine);
        WineResponse response = wineMapper.wineToWineResponse(updatedWine);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWineById(@PathVariable Long id) {
        if (this.wineService.deleteWineById(id) > 0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}