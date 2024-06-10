package org.example.winemanagementapi.controllers;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.BoxConverter;
import org.example.winemanagementapi.converters.GrapeConverter;
import org.example.winemanagementapi.dto.BoxResponse;
import org.example.winemanagementapi.dto.GrapeResponse;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.services.GrapeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
