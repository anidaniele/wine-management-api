package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.WineConverter;
import org.example.winemanagementapi.dto.WineRequest;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.entities.Wine;
import org.example.winemanagementapi.exceptions.ValidationErrorResponse;
import org.example.winemanagementapi.repositories.WineRepository;
import org.example.winemanagementapi.services.GrapeService;
import org.example.winemanagementapi.services.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wines")
public class WineController {
    private final WineService wineService;
    private final GrapeService grapeService;

    @GetMapping
    public ResponseEntity<List<WineResponse>> getAllWines() {
        List<Wine> wines = this.wineService.getAllWines();
        if (wines.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(WineConverter.convertWinesToWineResponseList(wines));
    }

    @PostMapping
    public ResponseEntity<?> addWine(@Valid @RequestBody WineRequest wineRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ValidationErrorResponse(bindingResult.getFieldErrors()));
        }

        Wine wine = WineConverter.convertWineRequestToWine(wineRequest);
        List<Grape> grapes = this.grapeService.getGrapesById(wineRequest.getGrapeIds());
        if (grapes.size() != wineRequest.getGrapeIds().size()){
            return ResponseEntity.notFound().build();
        }

        wine.setGrapes(grapes);
        Wine addedWine = this.wineService.addWine(wine);
        return ResponseEntity.status(HttpStatus.CREATED).body(WineConverter.convertWineToWineResponse(addedWine));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineResponse> getwine(@PathVariable Long id) {
        Wine wine = this.wineService.getWineById(id);
        if (wine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(WineConverter.convertWineToWineResponse(wine));
    }


}
