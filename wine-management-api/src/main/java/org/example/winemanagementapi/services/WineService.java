package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.entities.Wine;
import org.example.winemanagementapi.repositories.WineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {

    private final WineRepository wineRepository;
    private final RegionService regionService;

    public List<Wine> getAllWines() { return wineRepository.findAll(); }

    public Wine getWineById(long id) { return wineRepository.findById(id).orElse(null); }

    public Wine addWine(Wine wine) { return wineRepository.saveAndFlush(wine); }


    public List<Wine> getWinesByRegionName(String name) {
        Region region = regionService.getRegionByName(name);
        return region.getWines();
    }

    public List<Wine> getWinesByCountry(String country) {
        List<Region> regions = regionService.getRegionsByCountry(country);
        List<Wine> wines = new ArrayList<>();
        for (Region region : regions) {
            wines.addAll(region.getWines());
        }
        return wines;
    }

    public long deleteWineById(Long id) { return wineRepository.removeById(id); }


}
