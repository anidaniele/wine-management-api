//package org.example.winemanagementapi.controllers;
//
//import lombok.RequiredArgsConstructor;
//
//import org.example.winemanagementapi.dto.BoxRequest;
//import org.example.winemanagementapi.dto.BoxResponse;
//import org.example.winemanagementapi.entities.Box;
//import org.example.winemanagementapi.mappers.BoxMapper;
//import org.example.winemanagementapi.mappers.WineMapper;
//import org.example.winemanagementapi.services.BoxService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/boxes")
//public class BoxController {
//
//    private final BoxService boxService;
//    private final BoxMapper boxMapper;
//
//    @GetMapping
//    public ResponseEntity<List<BoxResponse>> getBoxes() {
//        List<Box> boxes = this.boxService.getAllBoxes();
//        if (boxes.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(boxes.stream().map(boxMapper::boxToBoxResponse).toList());
//    }
//
//}
