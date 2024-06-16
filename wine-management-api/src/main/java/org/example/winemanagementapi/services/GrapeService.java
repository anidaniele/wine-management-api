package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.repositories.GrapeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GrapeService {

    private final GrapeRepository grapeRepository;

    public List<Grape> getAllGrapes() { return grapeRepository.findAll(); }

    public Grape addGrape(Grape grape) { return grapeRepository.saveAndFlush(grape); }

    public List<Grape> getGrapesByTitle(List<String> titles) {
        List<Grape> grapes = grapeRepository.findByTitleIn(titles);
        if (grapes == null || grapes.isEmpty()) {
            throw new ResourceNotFoundException("No grapes found with titles " + titles);
        }
        return grapes;
    }

    public int deleteGrapeById(Long id) {
        Optional<Grape> grapeOptional = grapeRepository.findById(id);
        if (grapeOptional.isPresent()) {
            Grape grape = grapeOptional.get();
            if (grape.getWines().isEmpty()) {
                grapeRepository.deleteById(id);
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

}
