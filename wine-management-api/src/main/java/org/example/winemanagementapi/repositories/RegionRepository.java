package org.example.winemanagementapi.repositories;

import org.example.winemanagementapi.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
