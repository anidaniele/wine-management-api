package org.example.winemanagementapi.dto.box;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.example.winemanagementapi.entities.Box;
import org.example.winemanagementapi.exceptions.UniqueField;

@Builder
public record BoxRequest (
    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50)
    @UniqueField(entity = Box.class, fieldName = "name", message = "Box already exists")
    String name
){}
