package org.example.winemanagementapi.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.winemanagementapi.dto.WineRequest;
import org.example.winemanagementapi.entities.Wine;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class WineConverter {

    public static Wine convertWineRequestToWine(WineRequest wineRequest) {
        Wine wine = null;
        if (wineRequest != null) {
            wine = new Wine();
            wine.setType(wineRequest.getType());
            wine.setTitle(wineRequest.getTitle());
            wine.setYear(wineRequest.getYear());
        }
        return wine;
    }

}
