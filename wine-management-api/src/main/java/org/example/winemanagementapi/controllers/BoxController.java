package org.example.winemanagementapi.controllers;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.BoxConverter;
import org.example.winemanagementapi.dto.BoxRequest;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.services.BoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boxes")
public class BoxController {

    private final BoxService boxService;

    @GetMapping
    public ResponseEntity<List<BoxRequest>> getBoxes() {
        List<Box> boxes = this.boxService.getAllBoxes();
        if (boxes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(BoxConverter.convertBoxRequestToBox())
    }

}
