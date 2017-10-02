package com.suis.logistics.model.thirdparty;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ThirdPartyCustomer {

	@JsonProperty("contact_id")
	private String					customerId;
	@JsonProperty("contact_name")
	private String					contactName;
	@JsonProperty("company_name")
	private String					companyName;
	@JsonProperty("billing_address")
	private ThirdPartyAddress		billingAddress;
	@JsonProperty("shipping_address")
	private ThirdPartyAddress		shippingAddress;
	@JsonProperty("contact_persons")
	private List<ThirdPartyPerson>	contacts;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ThirdPartyAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(ThirdPartyAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ThirdPartyAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ThirdPartyAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<ThirdPartyPerson> getContacts() {
		return contacts;
	}

	public void setContacts(List<ThirdPartyPerson> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "ThirdPartyCustomer [customerId=" + customerId + ", contactName=" + contactName + ", companyName="
				+ companyName + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
				+ ", contacts=" + contacts + "]";
	}
}
