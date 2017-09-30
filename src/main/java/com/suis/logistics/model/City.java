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
@Table(name = "m_city_state_country")
@NamedQueries({
		@NamedQuery(name = "City.findAll", query = "SELECT c FROM City c order by c.id asc"),
		@NamedQuery(name = "City.findByName", query = "SELECT c FROM City c where c.name like :name") })
public class City implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	@Column(name="city_name")
	private String				name;
	@Column(name="country_name")
	private String				countryName;
	@Column(name="country_iso_code")
	private String				countryCode;
	@Column(name="state_name")
	private String				stateName;
	@Column(name="state_iso_code")
	private String				stateCode;
	@Column(name="time_zone")
	private String				timeZone;
	@Column(name="timezone_abbereviation")
	private String timeZoneAbbereviation;
	@Column(name="subdivision_2_name")
	private String subdivisionName; //  not in use right now, but can be used if state is not present

	/*
	 * @ManyToOne private State state;
	 *
	 * @Column(name ="timezone_id") private String timeZoneId;
	 *
	 * @Column(name="timezone_abbreviation") private String
	 * timeZoneAbbereviation;
	 */
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getTimeZoneAbbereviation() {
		return timeZoneAbbereviation;
	}

	public void setTimeZoneAbbereviation(String timeZoneAbbereviation) {
		this.timeZoneAbbereviation = timeZoneAbbereviation;
	}

	public String getSubdivisionName() {
		return subdivisionName;
	}

	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", stateName=" + stateName + ", stateCode=" + stateCode + ", timeZone=" + timeZone
				+ ", timeZoneAbbereviation=" + timeZoneAbbereviation + ", subdivisionName=" + subdivisionName + "]\n";
	}


}
