package org.example.winemanagementapi.converters;

import org.example.winemanagementapi.dto.BoxRequest;
import org.example.winemanagementapi.entities.Box;

public class BoxConverter {

    public static Box convertBoxRequestToBox(BoxRequest boxRequest) {
        Box box = null;
        if (boxRequest != null) {
            box = new Box();
            box.setName(boxRequest.getName());
        }
        return box;
    }
}
