package com.suis.logistics.web;

public class TimeZoneDto {

	private String timeZoneId;
	private String timeZoneShortName;

	public TimeZoneDto(String timeZoneId, String timeZoneShortName) {
		super();
		this.timeZoneId = timeZoneId;
		this.timeZoneShortName = timeZoneShortName;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public String getTimeZoneShortName() {
		return timeZoneShortName;
	}


}
