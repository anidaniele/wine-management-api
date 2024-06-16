package org.example.winemanagementapi.controllers;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.converters.BoxConverter;
import org.example.winemanagementapi.dto.BoxRequest;
import org.example.winemanagementapi.dto.BoxResponse;
import org.example.winemanagementapi.dto.BoxWineResponse;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.exceptions.ValidationErrorResponse;
import org.example.winemanagementapi.services.BoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boxes")
//@Validated
public class BoxController {

    private final BoxService boxService;

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping
    public ResponseEntity<List<BoxWineResponse>> getBoxes() {
        List<Box> boxes = this.boxService.getAllBoxes();
        if (boxes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(BoxConverter.convertBoxListToBoxWineResponseList(boxes));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("{wineId}")
    public ResponseEntity<BoxResponse> getBoxByWineId(@PathVariable Long wineId) {
        Box box = this.boxService.getBoxByWineId(wineId);
        if (box == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BoxConverter.convertBoxToBoxResponse(box));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createBox(@RequestBody BoxRequest boxRequest,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ValidationErrorResponse(bindingResult.getFieldErrors()));
        }
        Box box = this.boxService.addBox(BoxConverter.convertBoxRequestToBox(boxRequest));
        return ResponseEntity.ok(BoxConverter.convertBoxToBoxResponse(box));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoxById(@PathVariable Long id) {
        if (this.boxService.deleteBoxById(id) > 0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
