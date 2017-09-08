package com.suis.logistics.exception;

public class BaseException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;
	private ErrorResponse		errorResponse;
	private String				developerMessage;

	public BaseException(ErrorResponse errorResponse, Throwable e) {
		super(e);
		this.errorResponse = errorResponse;
		this.developerMessage = e.getMessage();
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
}
