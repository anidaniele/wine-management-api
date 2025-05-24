package org.example.winemanagementapi.repositories;

import jakarta.transaction.Transactional;
import org.example.winemanagementapi.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    @Transactional
    long removeById(Long id);

}
