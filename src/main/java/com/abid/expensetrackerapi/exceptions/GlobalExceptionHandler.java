package com.abid.expensetrackerapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.abid.expensetrackerapi.entity.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request){
		
		ErrorObject errorObject =  new ErrorObject();
		
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request){
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorObject.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request){
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorObject.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
