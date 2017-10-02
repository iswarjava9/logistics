package com.suis.logistics.repository.booking;

import org.springframework.core.env.Environment;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class BookingNotFoundException extends BaseException{

	private static final long serialVersionUID = 1L;

	public BookingNotFoundException(Throwable e, Environment env) {
		super(new ErrorResponse(1004, env), e);
	}
}
