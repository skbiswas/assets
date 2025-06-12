package com.skb.app.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 */

/**
 * @author skbiswas
 *
 */
@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ErrorMessage eMsg = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<Object>(eMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNPException(NullPointerException npe, WebRequest request) {
		ErrorMessage msg = new ErrorMessage(new Date(), npe.getMessage());
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
		ErrorMessage msg = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	@ExceptionHandler(value = { UserServiceException.class, NullPointerException.class })
	public ResponseEntity<Object> handleMultipleExceptions(Exception ex, WebRequest request) {
		ErrorMessage msg = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
