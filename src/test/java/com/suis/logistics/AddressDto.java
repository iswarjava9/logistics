package com.suis.logistics;

public class AddressDto {
	private String pin;
	private String details;


	public AddressDto(String pin, String details) {
		super();
		this.pin = pin;
		this.details = details;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}


}
