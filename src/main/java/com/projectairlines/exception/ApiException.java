package com.projectairlines.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;
	private final StackTraceElement[] stackTraceElement;
	
	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp, StackTraceElement[] stackTraceElements) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
		this.stackTraceElement = stackTraceElements;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public StackTraceElement[] getStackTraceElement() {
		return stackTraceElement;
	}
}
