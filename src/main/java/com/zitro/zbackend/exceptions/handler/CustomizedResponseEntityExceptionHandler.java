package com.zitro.zbackend.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.exceptions.NoFundsException;
import com.zitro.zcommon.exceptions.BadRequestException;
import com.zitro.zcommon.exceptions.ConflictException;
import com.zitro.zcommon.exceptions.NotFoundException;
import com.zitro.zcommon.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundExceptions(NotFoundException ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundExceptions(ResourceNotFoundException ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConflictException.class)
	public final ResponseEntity<Object> handleConflictExceptions(ConflictException ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestExceptions(BadRequestException ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoFundsException.class)
	public final ResponseEntity<Object> handleNoFundsExceptions(NoFundsException ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DeletedUserException.class)
	public final ResponseEntity<Object> handleDeletedUserException(DeletedUserException ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
}
