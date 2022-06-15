package com.projectairlines.exception;

public class FlightNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlightNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightNotFoundException(String message) {
		super(message);
	}

	public FlightNotFoundException(Throwable cause) {
		super(cause);
	}
}
