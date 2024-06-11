package org.example.winemanagementapi.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.winemanagementapi.dto.GrapeRequest;
import org.example.winemanagementapi.dto.GrapeResponse;
import org.example.winemanagementapi.entities.Grape;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class GrapeConverter {

    public static Grape convertGrapeRequestToGrape(GrapeRequest grapeRequest) {
        Grape grape = null;
        if (grapeRequest != null) {
            grape = new Grape();
            grape.setTitle(grapeRequest.getTitle());
            grape.setDescription(grapeRequest.getDescription());
        }
        return grape;
    }

    public static GrapeResponse convertGrapeToGrapeResponse(Grape grape) {
        GrapeResponse grapeResponse = null;
        if (grape != null) {
            grapeResponse = new GrapeResponse();
            grapeResponse.setId(grape.getId());
            grapeResponse.setTitle(grape.getTitle());
            grapeResponse.setDescription(grape.getDescription());
            grapeResponse.setWines(WineConverter.convertWinesToWineResponseList(grape.getWines()));
        }
        return grapeResponse;
    }

    public static List<GrapeResponse> convertGrapeListToGrapeResponseList(List<Grape> grapes) {
        List<GrapeResponse> grapeResponses = new ArrayList<>();
        for (Grape grape : grapes) {
            grapeResponses.add(convertGrapeToGrapeResponse(grape));
        }
        return grapeResponses;
    }
}
