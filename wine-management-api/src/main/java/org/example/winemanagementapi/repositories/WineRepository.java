package org.example.winemanagementapi.repositories;

import org.example.winemanagementapi.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Long> {

    public List<Wine> findWinesByType(String type);
    //public List<Wine> findWinesByGrapeId(Long id); -- sitas is Grapes repo
}
