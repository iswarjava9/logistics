package com.suis.logistics.web.businessline;

public class BusinessLineDto {

	private Integer	id;
	private String	description;
	private Integer	lineOfBusiness;
	private String	transportMode;
	private String	transportType;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(Integer lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getTransportType() {
		return transportType;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}



}
