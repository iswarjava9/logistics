package com.suis.logistics.repository.booking;

import org.springframework.core.env.Environment;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class CreateBookingFailedException extends BaseException {

	private static final long serialVersionUID = 1L;

	public CreateBookingFailedException(Throwable e, Environment env) {
		super(new ErrorResponse(1000, env), e);
	}
}
