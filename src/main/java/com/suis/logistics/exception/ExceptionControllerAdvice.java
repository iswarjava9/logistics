package com.suis.logistics.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.suis.logistics.repository.booking.BookingNotFoundException;
import com.suis.logistics.repository.booking.CreateBookingFailedException;
import com.suis.logistics.repository.customer.AddCustomerFailedException;
import com.suis.logistics.repository.person.PersonNotFoundException;
import com.suis.logistics.repository.place.AddPlaceFailedException;
import com.suis.logistics.service.customer.ThirdPartyCustomerCreationFailedException;
import com.suis.logistics.service.invoice.InvoiceCreationFailedException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	Environment env;

	@ExceptionHandler(CreateBookingFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CreateBookingFailedException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AddCustomerFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(AddCustomerFailedException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AddPlaceFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(AddPlaceFailedException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ex.printStackTrace();
		ErrorResponse errorResponse = new ErrorResponse(5000, env);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(BookingNotFoundException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvoiceCreationFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(InvoiceCreationFailedException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ThirdPartyCustomerCreationFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ThirdPartyCustomerCreationFailedException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(PersonNotFoundException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.NOT_FOUND);
	}
}
