package org.example.winemanagementapi.repositories;

import org.example.winemanagementapi.entities.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {
}
