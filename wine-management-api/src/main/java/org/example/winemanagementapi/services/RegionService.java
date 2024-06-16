package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Region;
import org.example.winemanagementapi.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getAllRegions() { return regionRepository.findAll(); }
    public List<Region> getRegionsByCountry(String country) { return regionRepository.findByCountry(country); }
    public Region getRegionByName(String name) { return regionRepository.findByName(name); }
    public Region addRegion(Region region) { return regionRepository.saveAndFlush(region); }
    public long deleteRegionById(Long id) { return regionRepository.removeById(id); }
}
