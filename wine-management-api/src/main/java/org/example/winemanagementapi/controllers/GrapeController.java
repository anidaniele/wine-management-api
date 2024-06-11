package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.GrapeConverter;
import org.example.winemanagementapi.dto.GrapeRequest;
import org.example.winemanagementapi.dto.GrapeResponse;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.exceptions.ValidationErrorResponse;
import org.example.winemanagementapi.services.GrapeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grapes")
public class GrapeController {
    private final GrapeService grapeService;

    @GetMapping
    public ResponseEntity<List<GrapeResponse>> getAllGrapes() {
        List<Grape> grapes = this.grapeService.getAllGrapes();
        if (grapes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(GrapeConverter.convertGrapeListToGrapeResponseList(grapes));
    }

    @PostMapping
    public ResponseEntity<?> createGrape(@Valid @RequestBody GrapeRequest grapeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(new ValidationErrorResponse(bindingResult.getFieldErrors()));
        }
        Grape grape = this.grapeService.addGrape(GrapeConverter.convertGrapeRequestToGrape(grapeRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(GrapeConverter.convertGrapeToGrapeResponse(grape));
    }

}
