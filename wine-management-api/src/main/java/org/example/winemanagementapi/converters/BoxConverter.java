package org.example.winemanagementapi.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.winemanagementapi.dto.BoxRequest;
import org.example.winemanagementapi.dto.BoxResponse;
import org.example.winemanagementapi.entities.Box;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class BoxConverter {

    public static Box convertBoxDtoToBox(BoxRequest boxRequest) {
        Box box = null;
        if (boxRequest != null) {
            box = new Box();
            box.setName(boxRequest.getName());
        }
        return box;
    }

    public static BoxResponse convertBoxToBoxResponse(Box box) {
        BoxResponse boxResponse = null;
        if (box != null) {
            boxResponse = new BoxResponse();
            boxResponse.setId(box.getId());
            boxResponse.setName(box.getName());
            boxResponse.setWines(WineConverter.convertWinesToWineResponseList(box.getWines()));
        }
        return boxResponse;
    }

    public static List<BoxResponse> convertBoxListToBoxResponseList(List<Box> boxList) {
        List<BoxResponse> boxResponseList = new ArrayList<>();
        for (Box box : boxList) {
            boxResponseList.add(convertBoxToBoxResponse(box));
        }
        return boxResponseList;
    }
}
