package org.example.winemanagementapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.dto.box.BoxRequest;
import org.example.winemanagementapi.dto.box.BoxResponse;
import org.example.winemanagementapi.dto.box.BoxWineResponse;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.exceptions.ConflictException;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.mappers.BoxMapper;
import org.example.winemanagementapi.services.BoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boxes")
public class BoxController {

    private final BoxService boxService;
    private final BoxMapper boxMapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<BoxWineResponse>> getBoxes() {
        List<Box> boxes = this.boxService.getAllBoxes();
        if (boxes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(boxes.stream().map(boxMapper::boxToBoxWineResponse).toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("{wineId}")
    public ResponseEntity<BoxResponse> getBoxByWineId(@PathVariable Long wineId) {
        Box box = this.boxService.getBoxByWineId(wineId);
        if (box == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(boxMapper.boxToBoxResponse(box));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<BoxResponse> createBox(@RequestBody @Valid BoxRequest boxRequest) {
        Box box = this.boxService.addBox(boxMapper.boxRequestToBox(boxRequest));
        BoxResponse response = boxMapper.boxToBoxResponse(box);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoxById(@PathVariable Long id) {
        int result = this.boxService.deleteBoxById(id);
        if (result > 0) {
            return ResponseEntity.noContent().build();
        } else if (result == 0) {
            throw new ResourceNotFoundException("Box not found with id " + id);
        } else {
            throw new ConflictException("Box cannot be deleted - it is not empty");
        }
    }
}
