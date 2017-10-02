package com.suis.logistics.web.customer;

import com.suis.logistics.web.CityDto;

public class CustomerDto extends CustomerBaseDto {

	private String	address;
	private String	personInCharge;
	private CityDto	city;
	private String	zipCode;
	private String	emailId;
	private String	phoneNo;
	private String	taxId;
	private Integer	clientId;
	private String  tpCustomerId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getTpCustomerId() {
		return tpCustomerId;
	}

	public void setTpCustomerId(String tpCustomerId) {
		this.tpCustomerId = tpCustomerId;
	}


}
