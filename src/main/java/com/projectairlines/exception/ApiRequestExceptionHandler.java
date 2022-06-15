package com.projectairlines.exception;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiRequestExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiRequestExceptionHandler.class);
	
	@ExceptionHandler(value = FlightNotFoundException.class)
	public ResponseEntity<ApiException> flightNotFoundExceptionHandler(FlightNotFoundException exception) {
		
		LOGGER.info("Executing ApiRequestExceptionHandler.apiExceptionHandler()");
		
		HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
		
		ApiException apiException = new ApiException(exception.getMessage(), 
				NOT_FOUND, 
				ZonedDateTime.now(),
				exception.getStackTrace()); 
		
		LOGGER.error("ApiRequestExceptionHandler.apiExceptionHandler(): ", exception);

		return new ResponseEntity<ApiException>(apiException, NOT_FOUND);

	}
	
	@ExceptionHandler(value = NewFlightIncomplete.class)
	public ResponseEntity<ApiException> newFlightIncompleteExceptionHandler(NewFlightIncomplete exception) {
		
		LOGGER.info("Executing ApiRequestExceptionHandler.newFlightIncompleteExceptionHandler()");
		
		HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
		
		ApiException apiException = new ApiException(exception.getMessage(),
				BAD_REQUEST,
				ZonedDateTime.now(),
				exception.getStackTrace());
		
		LOGGER.error("ApiRequestExceptionHandler.newFlightIncompleteExceptionHandler() -> ", exception);
		
		return new ResponseEntity<ApiException>(apiException, BAD_REQUEST);

	}
	
	@ExceptionHandler(value = FlightAlreadyExistsException.class)
	public ResponseEntity<ApiException> flightAlreadyExistsExceptionHandler(FlightAlreadyExistsException exception) {
		
		LOGGER.info("Executing ApiRequestExceptionHandler.flightAlreadyExistsException()");
		
		HttpStatus UNAUTHORIZED = HttpStatus.UNAUTHORIZED;
		
		ApiException apiException = new ApiException(exception.getMessage(),
				UNAUTHORIZED,
				ZonedDateTime.now(),
				exception.getStackTrace());
		
		LOGGER.error("ApiRequestExceptionHandler.flightAlreadyExistsExceptionHandler() -> ", exception);
		
		return new ResponseEntity<ApiException>(apiException, UNAUTHORIZED);
		
	}
	
	@ExceptionHandler(value = UpdateFailedException.class)
	public ResponseEntity<ApiException> updateFailedExceptionHandler(UpdateFailedException exception) {
		
		LOGGER.info("Executing ApiRequestExceptionHandler.updateFailedExceptionHandler()");
		
		HttpStatus UNAUTHORIZED = HttpStatus.UNAUTHORIZED;
		
		ApiException apiException = new ApiException(exception.getMessage(),
				UNAUTHORIZED,
				ZonedDateTime.now(),
				exception.getStackTrace());
		
		LOGGER.error("ApiRequestExceptionHandler.updateFailedExceptionHandler() -> ", exception);
		
		return new ResponseEntity<ApiException>(apiException, UNAUTHORIZED);
		
	}
	
}
