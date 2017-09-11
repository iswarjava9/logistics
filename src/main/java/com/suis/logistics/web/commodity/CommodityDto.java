package com.suis.logistics.web.commodity;

public class CommodityDto {
	private int					id;
	private String				name;
	private String				description;
	private String				primaryQuantity;
	private String				scheduleB;
	private String				secondaryQuantity;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrimaryQuantity() {
		return primaryQuantity;
	}
	public void setPrimaryQuantity(String primaryQuantity) {
		this.primaryQuantity = primaryQuantity;
	}
	public String getScheduleB() {
		return scheduleB;
	}
	public void setScheduleB(String scheduleB) {
		this.scheduleB = scheduleB;
	}
	public String getSecondaryQuantity() {
		return secondaryQuantity;
	}
	public void setSecondaryQuantity(String secondaryQuantity) {
		this.secondaryQuantity = secondaryQuantity;
	}


}
