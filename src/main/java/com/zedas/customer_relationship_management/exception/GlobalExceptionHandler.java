package com.zedas.customer_relationship_management.exception;

import com.zedas.customer_relationship_management.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorResponse(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        ValidationErrorResponse error = new ValidationErrorResponse(
                "email",
                "Email address already exists"
        );
        return new ResponseEntity<>(Collections.singletonList(error), HttpStatus.BAD_REQUEST);
    }
}
