package com.suis.logistics.web.place;

public class PlaceDto extends PlaceBaseDto{

	private Integer	brokerageRate;
	private String	code;
	private String	countryCode;
	private String	portStateCode;
	private Integer	typeId;
	private String	unCode;
	private String address;


	public Integer getBrokerageRate() {
		return brokerageRate;
	}
	public void setBrokerageRate(Integer brokerageRate) {
		this.brokerageRate = brokerageRate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPortStateCode() {
		return portStateCode;
	}
	public void setPortStateCode(String portStateCode) {
		this.portStateCode = portStateCode;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getUnCode() {
		return unCode;
	}
	public void setUnCode(String unCode) {
		this.unCode = unCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
