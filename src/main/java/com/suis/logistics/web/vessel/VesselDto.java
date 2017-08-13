package com.suis.logistics.web.vessel;

import com.suis.logistics.web.CountryDto;

public class VesselDto {
	private Integer	id;
	private String	lloydsCode;
	private String	name;
	private String	vesselNo;
	private CountryDto	country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getLloydsCode() {
		return lloydsCode;
	}

	public void setLloydsCode(String lloydsCode) {
		this.lloydsCode = lloydsCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVesselNo() {
		return vesselNo;
	}

	public void setVesselNo(String vesselNo) {
		this.vesselNo = vesselNo;
	}

	public CountryDto getCountry() {
		return country;
	}

	public void setCountry(CountryDto country) {
		this.country = country;
	}


}
