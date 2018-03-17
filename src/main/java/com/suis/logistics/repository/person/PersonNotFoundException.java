/**
 * @author Iswar
 */
package com.suis.logistics.repository.person;

import com.suis.logistics.exception.BaseException;
import com.suis.logistics.exception.ErrorResponse;

public class PersonNotFoundException extends BaseException {

	public PersonNotFoundException(Throwable e) {
		super(new ErrorResponse(1007), e);

	}

	private static final long serialVersionUID = 1L;

}
