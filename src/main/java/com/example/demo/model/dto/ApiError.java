package com.example.demo.model.dto;

public class ApiError {
    private String ex;

    public ApiError(String exception){
        this.ex = exception;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
