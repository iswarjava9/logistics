package com.suis.logistics.web.containertype;

public class ContainerTypeDto {

	private Integer	id;
	private Double	cbm;
	private Double	teu;
	private String	containerType;
	private String	descirption;
	private String	isoCode;
	private String	size;
	private String	type;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCbm() {
		return cbm;
	}
	public void setCbm(Double cbm) {
		this.cbm = cbm;
	}
	public Double getTeu() {
		return teu;
	}
	public void setTeu(Double teu) {
		this.teu = teu;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public String getDescirption() {
		return descirption;
	}
	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
