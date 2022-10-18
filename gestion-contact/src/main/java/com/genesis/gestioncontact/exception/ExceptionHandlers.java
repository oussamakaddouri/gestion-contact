package com.genesis.gestioncontact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorResponse> handleInValidArgumentException(MethodArgumentNotValidException e) {
	        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getFieldError().getDefaultMessage());
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }	
	    
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
	        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	    
	   }


