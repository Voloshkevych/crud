package com.homework.crud.exception;

import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleBookNotFoundException(BookNotFoundException e) {
    Map<String, Object> body = new HashMap<>();
    body.put("statusCode", HttpStatus.NOT_FOUND.value());
    body.put("message", e.getMessage());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException e) {
    Map<String, Object> body = new HashMap<>();

    String message = e.getConstraintViolations().stream()
        .map(violation -> violation.getMessage())
        .collect(Collectors.joining("; "));

    body.put("statusCode", HttpStatus.BAD_REQUEST.value());
    body.put("message", message);
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}
