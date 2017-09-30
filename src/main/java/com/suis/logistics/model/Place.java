package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the physical_entity database table.
 *
 */
@Entity
@Table(name = "place_copy")
@NamedQueries({ @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
		@NamedQuery(name = "Place.findByName", query = "SELECT p FROM Place p where p.name like :name") })
public class Place implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	private String				code;
	private String				name;
	@Column(name = "timezone_id")
	private String				timeZoneId;
	@Column(name = "timezone_shortname")
	private String				timeZoneShortName;
	@Column(name = "address")
	private String				address;
	@OneToOne
	@JoinColumn(name = "city_id")
	private City				city;

	public Place() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getTimeZoneShortName() {
		return timeZoneShortName;
	}

	public void setTimeZoneShortName(String timeZoneShortName) {
		this.timeZoneShortName = timeZoneShortName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
