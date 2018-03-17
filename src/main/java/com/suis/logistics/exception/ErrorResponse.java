package com.suis.logistics.exception;

import org.springframework.core.env.Environment;

import com.suis.logistics.common.ApplicationContextProvider;

public class ErrorResponse{

	private Integer	errorCode;
	private String	errorMessage;
	private String	developerMessage;
	private Environment envn = ApplicationContextProvider.getBean(Environment.class);


	public ErrorResponse() {

	}

	public ErrorResponse(Integer errorCode, Environment env) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = env.getProperty(String.valueOf(errorCode));
	}

	public ErrorResponse(Integer errorCode) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = envn.getProperty(String.valueOf(errorCode));
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

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
