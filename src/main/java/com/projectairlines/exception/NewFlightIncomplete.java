package com.projectairlines.exception;

public class NewFlightIncomplete extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NewFlightIncomplete(String message, Throwable cause) {
		super(message, cause);
	}

	public NewFlightIncomplete(String message) {
		super(message);
	}

	public NewFlightIncomplete(Throwable cause) {
		super(cause);
	}
	
}
