package com.suis.logistics.exception;

import org.springframework.core.env.Environment;


public class ErrorResponse {
	private Integer	errorCode;
	private String	errorMessage;

	public ErrorResponse() {

	}

	public ErrorResponse(Integer errorCode, Environment env) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = env.getProperty(String.valueOf(errorCode));
	}

	public ErrorResponse(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {

		return errorMessage;
	}
}
