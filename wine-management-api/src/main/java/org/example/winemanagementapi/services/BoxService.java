package org.example.winemanagementapi.services;

import lombok.RequiredArgsConstructor;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.entities.Wine;
import org.example.winemanagementapi.repositories.BoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoxService {

    private final BoxRepository boxRepository;
    private final WineService wineService;

    public List<Box> getAllBoxes() { return boxRepository.findAll(); }

    public Box addBox(Box box) { return boxRepository.saveAndFlush(box); }

    public Box getBoxByName(String name) { return boxRepository.findByName(name); }

    public Box getBoxByWineId(Long wineId) {
        Wine wine = wineService.getWineById(wineId);
        return wine.getBox();
    }

    public int deleteBoxById(Long id) {
        Optional<Box> boxOptional = boxRepository.findById(id);
        if (boxOptional.isPresent()) {
            Box box = boxOptional.get();
            if (box.getWines().isEmpty()) {
                boxRepository.deleteById(id);
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

}
