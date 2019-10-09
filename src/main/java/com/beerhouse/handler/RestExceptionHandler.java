package com.beerhouse.handler;

import com.beerhouse.error.ResourceNotFoundDetails;
import com.beerhouse.error.ResourceNotFoundException;
import com.beerhouse.error.ValidationErrorDetails;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfnException) {
		ResourceNotFoundDetails build = ResourceNotFoundDetails.Builder
				                                               .newBuilder()
				                                               .timestamp(new Date().getTime())
				                                               .status(HttpStatus.NOT_FOUND.value())
				                                               .title("Resource Not Found")
				                                               .detail(rnfnException.getMessage())
				                                               .developerMessage(rnfnException.getClass().getName())
				                                               .build();
		return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationErrorDetails(MethodArgumentNotValidException manvException) {
		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		String fields        = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		
		ValidationErrorDetails build =   ValidationErrorDetails.Builder
				                                               .newBuilder()
				                                               .timestamp(new Date().getTime())
				                                               .status(HttpStatus.BAD_REQUEST.value())
				                                               .title("Field Validation Error")
				                                               .detail("Field Validation Error")
				                                               .developerMessage(manvException.getClass().getName())
				                                               .fieldMessage(fieldMessages)
				                                               .field(fields)
				                                               .build();
		return new ResponseEntity<>(build, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
