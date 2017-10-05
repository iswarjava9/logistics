package com.suis.logistics.service.customer;

import org.springframework.core.env.Environment;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class ThirdPartyCustomerCreationFailedException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ThirdPartyCustomerCreationFailedException(Throwable e, Environment env) {
		super(new ErrorResponse(1006, env), e);
	}
}
