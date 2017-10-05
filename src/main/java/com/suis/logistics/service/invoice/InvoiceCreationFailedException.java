package com.suis.logistics.service.invoice;

import org.springframework.core.env.Environment;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class InvoiceCreationFailedException extends BaseException {

	private static final long serialVersionUID = 1L;

	public InvoiceCreationFailedException(Throwable e, Environment env) {
		super(new ErrorResponse(1005, env), e);
	}

	public InvoiceCreationFailedException(String errorMessage, Environment env) {
		super(new ErrorResponse(1005, env), errorMessage);
	}
}
