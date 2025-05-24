package org.example.winemanagementapi.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;

import java.util.List;

@Slf4j
@Getter
@Setter
public class ValidationErrorResponse {
    private List<String> errors;

    public ValidationErrorResponse(List<FieldError> fieldErrors) {
        this.errors = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .toList();
    }
}
