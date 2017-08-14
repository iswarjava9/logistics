package com.suis.logistics.web.cargotemplate;

import com.suis.logistics.web.commodity.CommodityDto;

public class CargoTemplateDto {

	private Integer			id;
	private String			cargoTypeCode;
	private String			description;
	private Integer			htsId;
	private CommodityDto	commodity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargoTypeCode() {
		return cargoTypeCode;
	}

	public void setCargoTypeCode(String cargoTypeCode) {
		this.cargoTypeCode = cargoTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHtsId() {
		return htsId;
	}

	public void setHtsId(Integer htsId) {
		this.htsId = htsId;
	}

	public CommodityDto getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityDto commodity) {
		this.commodity = commodity;
	}
}
