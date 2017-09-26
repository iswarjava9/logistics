package com.suis.logistics.web;

public class TimeZoneDto {

	private Integer id;
	private String zoneId;
	private String countryCode;

	public TimeZoneDto() {
		super();
	}
	public TimeZoneDto(String zoneId) {
		super();
		this.zoneId = zoneId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



}
