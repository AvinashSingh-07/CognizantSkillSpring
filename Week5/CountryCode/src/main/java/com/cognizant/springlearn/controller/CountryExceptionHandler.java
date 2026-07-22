package com.cognizant.springlearn.controller;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CountryExceptionHandler {

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCountryNotFound(CountryNotFoundException exception,
                                                                     HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        body.put("message", exception.getMessage());
        body.put("path", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
