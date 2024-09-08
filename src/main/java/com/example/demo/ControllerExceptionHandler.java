package com.example.demo;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.ArrayList;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> badRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ArrayList<String> errors = new ArrayList<>();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), request.getRequestURI(), HttpStatus.BAD_REQUEST.value(), Instant.now().toString());

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + " " + error.getDefaultMessage());
        }
        errorResponse.setMessage(String.join(", ", errors));
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequest(BadRequestException ex, HttpServletRequest request) {
        ErrorResponse obj = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), request.getRequestURI(), HttpStatus.BAD_REQUEST.value(), Instant.now().toString(), ex.getMessage());
        return ResponseEntity.badRequest().body(obj);
    }

}
