package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getAllRegions() { return regionRepository.findAll(); }
    public List<Region> getRegionsByCountry(String country) { return regionRepository.findByCountry(country); }
    public Region getRegionByName(String name) { return regionRepository.findByName(name); }
    public Region addRegion(Region region) { return regionRepository.saveAndFlush(region); }

    public int deleteRegionById(Long id) {
        Optional<Region> regionOptional = regionRepository.findById(id);
        if (regionOptional.isPresent()) {
            Region region = regionOptional.get();
            if (region.getWines().isEmpty()) {
                regionRepository.deleteById(id);
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
