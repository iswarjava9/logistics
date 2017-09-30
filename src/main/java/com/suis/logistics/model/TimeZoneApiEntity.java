package com.suis.logistics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZoneApiEntity {

	 private String countryCode;
     private String countryName;
     private String regionName;
     private String cityName;
     private String zoneName;
     private String abbreviation;
     private Integer gmtOffset;
     private String dst;
     private Long dstStart;
     private Long dstEnd;
     private Long timestamp;
     private String formatted;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public Integer getGmtOffset() {
		return gmtOffset;
	}
	public void setGmtOffset(Integer gmtOffset) {
		this.gmtOffset = gmtOffset;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public Long getDstStart() {
		return dstStart;
	}
	public void setDstStart(Long dstStart) {
		this.dstStart = dstStart;
	}

	public Long getDstEnd() {
		return dstEnd;
	}
	public void setDstEnd(Long dstEnd) {
		this.dstEnd = dstEnd;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getFormatted() {
		return formatted;
	}
	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}



}
