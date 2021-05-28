package com.hlhan.Basic.common;

import com.hlhan.Basic.constants.ResultConstants;
import com.hlhan.Basic.component.MessageComponent;
import com.hlhan.Basic.dto.response.ResponseResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
    MessageComponent messageComponent;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
	    List<String> errors = new ArrayList<String>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(error.getField() + ": " + error.getDefaultMessage());
	    }
	    
	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	    }
	    
	    ResponseResultObject apiError = new ResponseResultObject(
	    		ResultConstants.CODE_VALIDATION_FAIL, messageComponent.getMessage("validation.error"),
				ex.getLocalizedMessage(), ((ServletWebRequest) request).getRequest().getRequestURI() );
	    apiError.setStatus(HttpStatus.BAD_REQUEST.value());
	    apiError.setTimeStamp(new Timestamp(new Date().getTime()));
	    // TODO : security 추가 후 로그 남기기
	    // final String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    // log.error("coCode - " + username + " :: " + apiError.toString());
	    
	    return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
	    String error = ex.getParameterName() + " parameter is missing";

		ResponseResultObject apiError = new ResponseResultObject(
				ResultConstants.CODE_VALIDATION_FAIL, messageComponent.getMessage("validation.error"),
				ex.getLocalizedMessage(), ((ServletWebRequest) request).getRequest().getRequestURI() );
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setTimeStamp(new Timestamp(new Date().getTime()));
		// final String username = SecurityContextHolder.getContext().getAuthentication().getName();
		// log.error("coCode - " + username + " :: " + apiError.toString());

		return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		
	    List<String> errors = new ArrayList<String>();
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
	    }

		ResponseResultObject apiError = new ResponseResultObject(
				ResultConstants.CODE_VALIDATION_FAIL, messageComponent.getMessage("validation.error"),
				ex.getLocalizedMessage(), ((ServletWebRequest) request).getRequest().getRequestURI() );
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setTimeStamp(new Timestamp(new Date().getTime()));
		// final String username = SecurityContextHolder.getContext().getAuthentication().getName();
		// log.error("coCode - " + username + " :: " + apiError.toString());

		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
		
	    String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

		ResponseResultObject apiError = new ResponseResultObject(
				ResultConstants.CODE_VALIDATION_FAIL, messageComponent.getMessage("validation.error"),
				ex.getLocalizedMessage(), ((ServletWebRequest) request).getRequest().getRequestURI() );
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setTimeStamp(new Timestamp(new Date().getTime()));
		// final String username = SecurityContextHolder.getContext().getAuthentication().getName();
		// log.error("coCode - " + username + " :: " + apiError.toString());

		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
}
