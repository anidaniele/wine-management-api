package org.example.winemanagementapi.repositories;

import org.example.winemanagementapi.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    public List<Wine> findWinesByType(String type);

}
