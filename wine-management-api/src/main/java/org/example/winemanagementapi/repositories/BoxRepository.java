package org.example.winemanagementapi.repositories;

import jakarta.transaction.Transactional;
import org.example.winemanagementapi.entities.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

    Box findByName(String name);

    @Transactional
    long removeById(Long id);
}
