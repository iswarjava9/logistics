package com.suis.logistics.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThirdPartyCustomerApiResponse {

	private String				code;
	private String				message;
	@JsonProperty("contact")
	private ThirdPartyCustomer	customer;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ThirdPartyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ThirdPartyCustomer customer) {
		this.customer = customer;
	}
}
