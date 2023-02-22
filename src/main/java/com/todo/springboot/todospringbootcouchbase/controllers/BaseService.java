package com.todo.springboot.todospringbootcouchbase.controllers;

import com.todo.springboot.todospringbootcouchbase.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseService {

    public ResponseEntity<?> getBadRequestError(String message) {
        ErrorResponse errorResponse1 = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
        return ResponseEntity.badRequest().body(errorResponse1);
    }
}
