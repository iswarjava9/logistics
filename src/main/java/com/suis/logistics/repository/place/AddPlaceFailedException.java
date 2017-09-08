package com.suis.logistics.repository.place;

import org.springframework.core.env.Environment;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class AddPlaceFailedException extends BaseException {
	private static final long serialVersionUID = 1L;

	public AddPlaceFailedException(Throwable e, Environment env) {
		super(new ErrorResponse(1003, env), e);
	}
}
