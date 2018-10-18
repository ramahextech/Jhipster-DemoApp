package com.ahextech.web.rest.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
	

	  @Override

	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,

	      HttpHeaders headers, HttpStatus status, WebRequest request) {

	    ErrorDetails errorDetails = new ErrorDetails("Username Validation Failed", "Email Validation Failed",

	        ex.getBindingResult().toString());

	    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	
	
}
}
