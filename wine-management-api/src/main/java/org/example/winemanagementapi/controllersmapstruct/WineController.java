//package org.example.winemanagementapi.controllers;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//
//import org.example.winemanagementapi.dto.WineRequest;
//import org.example.winemanagementapi.dto.WineResponse;
//import org.example.winemanagementapi.entities.Grape;
//import org.example.winemanagementapi.entities.Region;
//import org.example.winemanagementapi.entities.Wine;
//import org.example.winemanagementapi.exceptions.ValidationErrorResponse;
//import org.example.winemanagementapi.mappers.WineMapper;
//import org.example.winemanagementapi.services.GrapeService;
//import org.example.winemanagementapi.services.RegionService;
//import org.example.winemanagementapi.services.WineService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/wines")
//public class WineController {
//    private final WineService wineService;
//    private final GrapeService grapeService;
//    private final RegionService regionService;
//    private final WineMapper wineMapper;
//
//
//    @GetMapping
//    public ResponseEntity<List<WineResponse>> getAllWines() {
//        List<Wine> wines = this.wineService.getAllWines();
//        if (wines.isEmpty()){
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(wines.stream().map(wineMapper::wineToWineResponse).toList());
//    }
//
//@PostMapping
//public ResponseEntity<?> addWine(@Valid @RequestBody WineRequest wineRequest, BindingResult bindingResult) {
//    if (bindingResult.hasErrors()) {
//        return ResponseEntity.badRequest().body(new ValidationErrorResponse(bindingResult.getFieldErrors()));
//    }
//
//    Wine wine = wineMapper.wineRequestToWine(wineRequest);
//    List<Grape> grapes = this.grapeService.getGrapesByTitle(wineRequest.grapeTitles());
//    if (grapes.size() != wineRequest.grapeTitles().size()){
//        return ResponseEntity.notFound().build();
//    }
//    Region region = this.regionService.getRegionByName(wineRequest.regionName());
//    wine.setRegion(region);
//    wine.setGrapes(grapes);
//    Wine addedWine = this.wineService.addWine(wine);
//    return ResponseEntity.status(HttpStatus.CREATED).body(wineMapper.wineToWineResponse(addedWine));
//}
//
//
//    @GetMapping("/country/{country}")
//    public ResponseEntity<List<WineResponse>> getAllWinesByCountry(@PathVariable String country) {
//        List<Wine> wines = this.wineService.getWinesByCountry(country);
//        if (wines.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(wines.stream().map(wineMapper::wineToWineResponse).toList());
//    }
//
//    @GetMapping("/region/{region}")
//    public ResponseEntity<List<WineResponse>> getAllWinesByRegion(@PathVariable String region) {
//        List<Wine> wines = this.wineService.getWinesByRegionName(region);
//        if (wines.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(wines.stream().map(wineMapper::wineToWineResponse).toList());
//    }
//
//
//}
