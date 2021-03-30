package com.byhi.example.theone.dto;

public class SortingDTO<T> {
    String sortType;
    String fieldName;
    T dtoData;

    public T getDtoData() {
        return dtoData;
    }

    public void setDtoData(T dtoData) {
        this.dtoData = dtoData;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
