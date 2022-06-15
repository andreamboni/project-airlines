package com.projectairlines.exception;

public class UpdateFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UpdateFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateFailedException(String message) {
		super(message);
	}

	public UpdateFailedException(Throwable cause) {
		super(cause);
	}

}
