package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.repositories.BoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoxService {

    private final BoxRepository boxRepository;

    public List<Box> getAllBoxes() { return boxRepository.findAll(); }

    public Box getBoxById(long id) { return boxRepository.findById(id).orElse(null); }

}
