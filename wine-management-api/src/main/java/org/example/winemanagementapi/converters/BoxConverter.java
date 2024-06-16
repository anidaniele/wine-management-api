package org.example.winemanagementapi.converters;

import org.example.winemanagementapi.dto.BoxRequest;
import org.example.winemanagementapi.dto.BoxResponse;
import org.example.winemanagementapi.dto.BoxWineResponse;
import org.example.winemanagementapi.entities.Box;

import java.util.ArrayList;
import java.util.List;

public final class BoxConverter {

    public static Box convertBoxRequestToBox(BoxRequest boxRequest) {
        Box box = null;
        if (boxRequest != null) {
            box = new Box();
            box.setName(boxRequest.name());
        }
        return box;
    }

    public static BoxResponse convertBoxToBoxResponse(Box box) {
        BoxResponse boxResponse = null;
        if (box != null) {
            boxResponse = BoxResponse.builder()
                    .id(box.getId())
                    .name(box.getName())
                    .build();
        }
        return boxResponse;
    }

    public static BoxWineResponse convertBoxToBoxWineResponse(Box box) {
        BoxWineResponse boxWineResponse = null;
        if (box != null) {
            boxWineResponse = BoxWineResponse.builder()
                    .id(box.getId())
                    .name(box.getName())
                    .wines(WineConverter.convertWinesToWineResponseList(box.getWines()))
                    .build();
        }
        return boxWineResponse;
    }

    public static List<BoxWineResponse> convertBoxListToBoxWineResponseList(List<Box> boxList) {
        List<BoxWineResponse> boxWineResponseList = new ArrayList<>();
        for (Box box : boxList) {
            boxWineResponseList.add(convertBoxToBoxWineResponse(box));
        }
        return boxWineResponseList;
    }
}
