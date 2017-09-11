package com.suis.logistics.web.place;

import com.suis.logistics.web.CityDto;

public class PlaceDto extends PlaceBaseDto {

	private String	code;
	private String	address;
	private CityDto	city;
	private String	timeZoneId;
	private String	timeZoneShortName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getTimeZoneShortName() {
		return timeZoneShortName;
	}

	public void setTimeZoneShortName(String timeZoneShortName) {
		this.timeZoneShortName = timeZoneShortName;
	}
}
