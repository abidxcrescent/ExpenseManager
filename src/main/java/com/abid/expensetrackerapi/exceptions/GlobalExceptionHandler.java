package com.abid.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.abid.expensetrackerapi.entity.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ExpenseNotFoundException ex, WebRequest request){
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);
	}

}
