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


    public Grape getGrapeById(Long id) { return this.grapeRepository.findById(id).orElse(null); }
    public List<Grape> getGrapesById(List<Long> ids) { return grapeRepository.findAllById(ids); }
    public List<Grape> getAllGrapes() { return grapeRepository.findAll(); }

    public List<Grape> getGrapesByTitle(List<String> titles) { return grapeRepository.findAllByTitleIn(titles); }
}
