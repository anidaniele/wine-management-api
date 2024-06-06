package org.example.winemanagementapi.repositories;

import org.example.winemanagementapi.entities.Grape;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrapeRepository extends JpaRepository<Grape, Long> {
}
