package org.example.exception;

import org.example.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        ApiResponse<Map<String, String>> apiResponse = new ApiResponse<>(
                errors,
                "loi validate",
                false
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());
        ApiResponse<Map<String, String>> apiResponse = new ApiResponse<>(
                errors,
                "khong tim thay du lieu",
                false
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
