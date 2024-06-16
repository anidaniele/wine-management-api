package org.example.winemanagementapi.converters;

import org.example.winemanagementapi.dto.GrapeRequest;
import org.example.winemanagementapi.dto.GrapeResponse;
//import org.example.winemanagementapi.dto.GrapeWineResponse;
import org.example.winemanagementapi.entities.Grape;

import java.util.ArrayList;
import java.util.List;


public final class GrapeConverter {

    public static Grape convertGrapeRequestToGrape(GrapeRequest grapeRequest) {
        Grape grape = null;
        if (grapeRequest != null) {
            grape = new Grape();
            grape.setTitle(grapeRequest.title());
            grape.setType(grapeRequest.type());
            grape.setDescription(grapeRequest.description());
        }
        return grape;
    }

    public static GrapeResponse convertGrapeToGrapeResponse(Grape grape) {
        GrapeResponse grapeResponse = null;
        if (grape != null) {
            grapeResponse = GrapeResponse.builder()
                    .id(grape.getId())
                    .title(grape.getTitle())
                    .type(grape.getType())
                    .description(grape.getDescription())
                    .build();
        }
        return grapeResponse;
    }

//    public static GrapeWineResponse convertGrapeToGrapeWineResponse(Grape grape) {
//        GrapeWineResponse grapeResponse = null;
//        if (grape != null) {
//            grapeResponse = GrapeWineResponse.builder()
//                    .id(grape.getId())
//                    .title(grape.getTitle())
//                    .type(grape.getType())
//                    .description(grape.getDescription())
//                    .wines(WineConverter.convertWinesToWineResponseList(grape.getWines()))
//                    .build();
//        }
//        return grapeResponse;
//    }

    public static List<GrapeResponse> convertGrapeListToGrapeResponseList(List<Grape> grapes) {
        List<GrapeResponse> grapeResponses = new ArrayList<>();
        for (Grape grape : grapes) {
            grapeResponses.add(convertGrapeToGrapeResponse(grape));
        }
        return grapeResponses;
    }

//    public static List<GrapeWineResponse> convertGrapeListToGrapeWineResponseList(List<Grape> grapes) {
//        List<GrapeWineResponse> grapeResponses = new ArrayList<>();
//        for (Grape grape : grapes) {
//            grapeResponses.add(convertGrapeToGrapeWineResponse(grape));
//        }
//        return grapeResponses;
//    }
}
