package com.suis.logistics.repository.customer;

import org.springframework.core.env.Environment;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class AddCustomerFailedException extends BaseException {
	private static final long serialVersionUID = 1L;

	public AddCustomerFailedException(Throwable e,Environment env) {
		super(new ErrorResponse(1001,env), e);
	}



}
