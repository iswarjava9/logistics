package com.suis.logistics.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZoneApiResponse {
	private String status;
	private String message;
	private Integer totalPage;
	private Integer currentPage;

	private List<TimeZoneApiEntity> zones;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public List<TimeZoneApiEntity> getZones() {
		return zones;
	}

	public void setZones(List<TimeZoneApiEntity> zones) {
		this.zones = zones;
	}




}
