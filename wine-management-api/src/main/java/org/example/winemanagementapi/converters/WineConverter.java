package org.example.winemanagementapi.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.winemanagementapi.dto.WineRequest;
import org.example.winemanagementapi.dto.WineResponse;
import org.example.winemanagementapi.entities.Wine;

import java.util.ArrayList;
import java.util.List;

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

    public static WineResponse convertWineToWineResponse(Wine wine) {
        WineResponse wineResponse = null;
        if (wine != null) {
            wineResponse = new WineResponse();
            wineResponse.setId(wine.getId());
            wineResponse.setTitle(wine.getTitle());
            wineResponse.setType(wine.getType());
            wineResponse.setYear(wine.getYear());
            wineResponse.setGrapes(GrapeConverter.convertGrapeListToGrapeResponseList(wine.getGrapes()));
            wineResponse.setRegion(RegionConverter.convertRegiontoRegionResponse(wine.getRegion()));
        }
        return wineResponse;
    }

    public static List<WineResponse> convertWinesToWineResponseList(List<Wine> wines) {
        List<WineResponse> wineResponses = new ArrayList<>();
        for (Wine wine : wines) {
            wineResponses.add(convertWineToWineResponse(wine));
        }
        return wineResponses;
    }

}
