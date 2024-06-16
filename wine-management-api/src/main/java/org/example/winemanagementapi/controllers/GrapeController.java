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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grapes")
public class GrapeController {
    private final GrapeService grapeService;

//    @GetMapping
//    public ResponseEntity<List<GrapeWineResponse>> getAllGrapes() {
//        List<Grape> grapes = this.grapeService.getAllGrapes();
//        if (grapes.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(GrapeConverter.convertGrapeListToGrapeWineResponseList(grapes));
//    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<GrapeResponse>> getAllGrapes() {
        List<Grape> grapes = this.grapeService.getAllGrapes();
        if (grapes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(GrapeConverter.convertGrapeListToGrapeResponseList(grapes));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<GrapeResponse> createGrape(@RequestBody @Valid GrapeRequest grapeRequest) {
        Grape grape = this.grapeService.addGrape(GrapeConverter.convertGrapeRequestToGrape(grapeRequest));
        GrapeResponse response = GrapeConverter.convertGrapeToGrapeResponse(grape);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrapeById(@PathVariable Long id) {
        if (this.grapeService.deleteGrapeById(id) > 0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
