package com.projectairlines.exception;

public class FlightAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlightAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightAlreadyExistsException(String message) {
		super(message);
	}

	public FlightAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
}
