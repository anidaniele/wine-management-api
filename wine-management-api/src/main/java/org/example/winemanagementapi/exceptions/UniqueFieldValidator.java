package org.example.winemanagementapi.exceptions;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

    @Autowired
    private EntityManager entityManager;

    private Class<?> entityClass;
    private String fieldName;

    @Override
    public void initialize(UniqueField constraintAnnotation) {
        this.entityClass = constraintAnnotation.entity();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null values can be handled separately if needed
        }

        String queryStr = String.format("SELECT COUNT(e) FROM %s e WHERE e.%s = :value",
                entityClass.getSimpleName(), fieldName);
        Long count = entityManager.createQuery(queryStr, Long.class)
                .setParameter("value", value)
                .getSingleResult();
        return count == 0;
    }
}

