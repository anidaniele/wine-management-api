//package org.example.winemanagementapi.mappers;
//
//import org.example.winemanagementapi.dto.WineRequest;
//import org.example.winemanagementapi.dto.WineResponse;
//import org.example.winemanagementapi.entities.Grape;
//import org.example.winemanagementapi.entities.Region;
//import org.example.winemanagementapi.entities.Wine;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class WineMapperImpl implements WineMapper {
//
//    @Override
//    public WineResponse wineToWineResponse(Wine wine) {
//        if (wine == null) {
//            return null;
//        }
//
//        List<String> grapeTitles = grapesToGrapeTitles(wine.getGrapes());
//
//        return WineResponse.builder()
//                .id(wine.getId())
//                .title(wine.getTitle())
//                .type(wine.getType())
//                .year(wine.getYear())
//                .regionName(wine.getRegion().getName())
//                .grapeTitles(grapeTitles)
//                .build();
//    }
//
//    @Override
//    public Wine wineRequestToWine(WineRequest wineRequest) {
//        if (wineRequest == null) {
//            return null;
//        }
//
//        Wine wine = new Wine();
//        wine.setTitle(wineRequest.title());
//        wine.setType(wineRequest.type());
//        wine.setYear(wineRequest.year());
//
//        Region region = new Region();
//        region.setName(wineRequest.regionName());
//        wine.setRegion(region);
//
//        List<Grape> grapes = grapeTitlesToGrapes(wineRequest.grapeTitles());
//
//        wine.setGrapes(grapes);
//
//        return wine;
//    }
//
//    @Override
//    public String grapeToGrapeTitle(Grape grape) {
//        if (grape == null) {
//            return null;
//        }
//        return grape.getTitle();
//    }
//
//    @Override
//    public Grape grapeTitleToGrape(String title) {
//        if (title == null) {
//            return null;
//        }
//        Grape grape = new Grape();
//        grape.setTitle(title);
//        return grape;
//    }
//
//    @Override
//    public List<String> grapesToGrapeTitles(List<Grape> grapes) {
//        if (grapes == null) {
//            return null;
//        }
//        return grapes.stream().map(this::grapeToGrapeTitle).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Grape> grapeTitlesToGrapes(List<String> grapeTitles) {
//        if (grapeTitles == null) {
//            return null;
//        }
//        return grapeTitles.stream().map(this::grapeTitleToGrape).collect(Collectors.toList());
//    }
//}
//
//
