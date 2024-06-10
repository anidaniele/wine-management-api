package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Wine;
import org.example.winemanagementapi.repositories.WineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {

    private final WineRepository wineRepository;

    public List<Wine> getAllWines() { return wineRepository.findAll(); }

    public Wine getWineById(long id) { return wineRepository.findById(id).orElse(null); }

    public Wine addWine(Wine wine) { return wineRepository.saveAndFlush(wine); }

    //public List<Wine> getWineByType(String type) {return wineRepository;}


}
