package org.example.winemanagementapi.converters;


import org.example.winemanagementapi.dto.GrapeRequest;
import org.example.winemanagementapi.entities.Grape;

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


}
