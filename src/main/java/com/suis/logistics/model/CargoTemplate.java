package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the cargo_template database table.
 *
 */
@Entity
@Table(name = "cargo_template")
@NamedQuery(name = "CargoTemplate.findAll", query = "SELECT c FROM CargoTemplate c")
public class CargoTemplate implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer					id;
	@Column(name = "cargo_type_code")
	private String				cargoTypeCode;
	private String				description;
	@Column(name = "hts_id")
	private Integer					htsId;
	// uni directional one-to-one association to Commodity
	@OneToOne
	@JoinColumn(name = "schedule_b_id")
	private Commodity			commodity;

	public CargoTemplate() {
	}

	public Integer getId() {
		return this.id;
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
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHtsId() {
		return this.htsId;
	}

	public void setHtsId(Integer htsId) {
		this.htsId = htsId;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
}
