package com.beerhouse.handler;

import com.beerhouse.error.ResourceNotFoundDetails;
import com.beerhouse.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfnException) {
        ResourceNotFoundDetails build = ResourceNotFoundDetails.Builder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource Not Found")
                .detail(rnfnException.getMessage())
                .developerMessage(rnfnException.getClass().getName())
                .build();
        return new ResposeEntity<>(build, HttpStatus.NOT_FOUND);
    }
}
