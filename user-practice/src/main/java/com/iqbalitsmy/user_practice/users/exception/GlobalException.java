package com.iqbalitsmy.user_practice.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iqbalitsmy.user_practice.users.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalException {
	// handle custom exception
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex){
		ErrorResponse error = new ErrorResponse( ex.getMessage(), 404);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleConflict(EmailAlreadyExistsException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 404);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

}
