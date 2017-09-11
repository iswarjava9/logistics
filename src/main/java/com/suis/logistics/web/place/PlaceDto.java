package com.suis.logistics.web.place;

import com.suis.logistics.web.CityDto;

public class PlaceDto extends PlaceBaseDto {

	private String	code;
	private String	address;
	private CityDto	city;
	private String	timezone;

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

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
