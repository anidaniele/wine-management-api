package org.example.winemanagementapi.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class ValidationErrorResponse {
    private List<String> errors;

//    public ValidationErrorResponse(List<FieldError> errors) {
//        super("Validation error", HttpStatus.BAD_REQUEST.value());
//
//        this.errors = new ArrayList<>();
//        for (FieldError error : errors) {
//            this.errors.add(String.format("%s: %s", error.getField(), error.getDefaultMessage()));
//        }
//    }

    public ValidationErrorResponse(List<FieldError> fieldErrors) {
        this.errors = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .toList();
    }
}
