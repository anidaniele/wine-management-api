package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.repositories.GrapeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GrapeService {
    private final GrapeRepository grapeRepository;

    public List<Grape> getAllGrapes() { return grapeRepository.findAll(); }
    public Grape addGrape(Grape grape) { return grapeRepository.saveAndFlush(grape); }
    public List<Grape> getGrapesByTitle(List<String> titles) { return grapeRepository.findByTitleIn(titles); }
    public long deleteGrapeById(Long id) { return grapeRepository.removeById(id); }

}
