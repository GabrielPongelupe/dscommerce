package com.gabrielpongelupe.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> fieldErrors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getFieldErrors() {
        return fieldErrors;
    }

    public void addError(String fieldName, String message) {
        this.fieldErrors.add(new FieldMessage(fieldName, message));
    }
}
