package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.exceptions.ResourceNotFoundException;
import org.example.winemanagementapi.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getAllRegions() { return regionRepository.findAll(); }

    public Region addRegion(Region region) { return regionRepository.saveAndFlush(region); }

    public Region getRegionByName(String name) {
        Region region = regionRepository.findByName(name);
        if (region == null) {
            throw new ResourceNotFoundException("Region with name " + name + " does not exist");
        }
        return region;
    }

    public List<Region> getRegionsByCountry(String country) {
        List<Region> regions = regionRepository.findByCountry(country);
        if (regions == null || regions.isEmpty()) {
            throw new ResourceNotFoundException("Country with name " + country + " does not exist or has no regions");
        }
        return regions;
    }

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
