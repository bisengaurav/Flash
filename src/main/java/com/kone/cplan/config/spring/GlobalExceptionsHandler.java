package com.kone.cplan.config.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kone.cplan.utils.dto.OperationResults;

/**
 * This class is used to handle all exceptions in one place.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<OperationResults> handleConflict(Exception ex, WebRequest request) {
		OperationResults badResults = OperationResults.newError(ex);
		return (new ResponseEntity<>(badResults, HttpStatus.INTERNAL_SERVER_ERROR));
	}
}