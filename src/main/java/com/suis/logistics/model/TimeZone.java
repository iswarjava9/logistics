package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "timezone")
@NamedQueries({ @NamedQuery(name = "TimeZone.findAll", query = "SELECT t FROM TimeZone t"),
		@NamedQuery(name = "TimeZones.findByCountryCode", query = "SELECT t FROM TimeZone t where t.countryCode = :countryCode") })
public class TimeZone implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer				id;
	@Column(name = "country_code")
	private String				countryCode;
	@Column(name = "zone_id")
	private String				zoneId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
}
