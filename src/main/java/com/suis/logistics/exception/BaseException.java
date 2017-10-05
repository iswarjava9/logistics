package com.suis.logistics.exception;

/**
 *
 * @author Iswar
 *
 */
public class BaseException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;
	private ErrorResponse		errorResponse;
	private String				developerMessage;

	public BaseException(ErrorResponse errorResponse, Throwable e) {
		super(e);
		this.errorResponse = errorResponse;
		this.developerMessage = e.getMessage();
		this.errorResponse.setDeveloperMessage(this.developerMessage);
	}

	public BaseException(ErrorResponse errorResponse, String errorMessage) {
		super();
		this.errorResponse = errorResponse;
		this.developerMessage = errorMessage;
		this.errorResponse.setDeveloperMessage(this.developerMessage);
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
