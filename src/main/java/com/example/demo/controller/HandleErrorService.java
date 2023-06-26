package com.example.demo.controller;

import com.example.demo.model.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandleErrorService {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ApiError> noSuchElementExceptionHandler(NoSuchElementException exception){
        return new ResponseEntity<>(
                new ApiError(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
