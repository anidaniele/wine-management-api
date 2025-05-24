package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.dto.grape.GrapeRequest;
import org.example.winemanagementapi.dto.grape.GrapeResponse;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.exceptions.ConflictException;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.mappers.GrapeMapper;
import org.example.winemanagementapi.services.GrapeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grapes")
public class GrapeController {
    private final GrapeService grapeService;
    private final GrapeMapper grapeMapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<GrapeResponse>> getAllGrapes() {
        List<Grape> grapes = this.grapeService.getAllGrapes();
        if (grapes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(grapes.stream().map(grapeMapper::grapeToGrapeResponse).toList());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<GrapeResponse> createGrape(@RequestBody @Valid GrapeRequest grapeRequest) {
        Grape grape = this.grapeService.addGrape(grapeMapper.grapeRequestToGrape(grapeRequest));
        GrapeResponse response = grapeMapper.grapeToGrapeResponse(grape);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrapeById(@PathVariable Long id) {
        int result = this.grapeService.deleteGrapeById(id);
        if (result > 0) {
            return ResponseEntity.noContent().build();
        } else if (result == 0) {
            throw new ResourceNotFoundException("Grape not found with id " + id);
        } else {
            throw new ConflictException("Grape cannot be deleted - it has associated wines to it");
        }
    }
}
