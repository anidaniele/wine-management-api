package org.example.winemanagementapi.converters;

import org.example.winemanagementapi.dto.WineRequest;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Grape;
import org.example.winemanagementapi.entities.Wine;

import java.util.ArrayList;
import java.util.List;

public final class WineConverter {

    public static Wine convertWineRequestToWine(WineRequest wineRequest) {
        Wine wine = null;
        if (wineRequest != null) {
            wine = new Wine();
            wine.setType(wineRequest.type());
            wine.setTitle(wineRequest.title());
            wine.setYear(wineRequest.year());
        }
        return wine;
    }

    public static WineResponse convertWineToWineResponse(Wine wine) {
        WineResponse wineResponse = null;
        if (wine != null) {
            wineResponse = WineResponse.builder()
                    .id(wine.getId())
                    .title(wine.getTitle())
                    .type(wine.getType())
                    .year(wine.getYear())
                    .regionName(wine.getRegion() != null ? wine.getRegion().getName() : null)
                    .grapeTitles(wine.getGrapes() != null ? wine.getGrapes().stream().map(Grape::getTitle).toList() : null)
                    .build();
        }
        return wineResponse;
    }

    public static List<WineResponse> convertWinesToWineResponseList(List<Wine> wines) {
        List<WineResponse> wineResponse = new ArrayList<>();
        for (Wine wine : wines) {
            wineResponse.add(convertWineToWineResponse(wine));
        }
        return wineResponse;
    }

}
