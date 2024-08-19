package com.poloit.gestorinscripciones.exceptions;

public class ResourceNotFoundException extends IllegalArgumentException {
    private  String resourceName;
    private  String fieldName;
    private  Long value;

    public ResourceNotFoundException(String message, String resourceName, String fieldName, Long value) {
        super(String.format("%s not found with: %s,'%s'",resourceName,fieldName, value));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }

    //getters  setters
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
