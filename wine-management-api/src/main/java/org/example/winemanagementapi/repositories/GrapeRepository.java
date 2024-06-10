package org.example.winemanagementapi.repositories;

import org.example.winemanagementapi.entities.Grape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrapeRepository extends JpaRepository<Grape, Long> {

    List<Grape> findAllByTitleIn(List<String> titles);
}
