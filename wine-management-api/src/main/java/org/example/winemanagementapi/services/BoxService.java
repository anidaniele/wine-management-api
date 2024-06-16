package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.entities.Wine;
import org.example.winemanagementapi.repositories.BoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoxService {

    private final BoxRepository boxRepository;
    private final WineService wineService;

    public List<Box> getAllBoxes() { return boxRepository.findAll(); }

    public Box addBox(Box box) { return boxRepository.saveAndFlush(box); }

    public long deleteBoxById(Long id) { return boxRepository.removeById(id); }

    public Box getBoxByName(String name) { return boxRepository.findByName(name); }

    public Box getBoxByWineId(Long wineId) {
        Wine wine = wineService.getWineById(wineId);
        return wine.getBox();
    }

}
