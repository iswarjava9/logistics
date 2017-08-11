package com.suis.logistics.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the commodity database table.
 *
 */
@Entity
@NamedQuery(name="Commodity.findAll", query="SELECT c FROM Commodity c")
public class Commodity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String commodity;

	private String description;

	@Column(name="primary_quantity")
	private String primaryQuantity;

	@Column(name="schedule_b")
	private String scheduleB;

	@Column(name="secondary_quantity")
	private String secondaryQuantity;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="commodity")
	private List<Cargo> cargos;

	//bi-directional many-to-one association to CargoTemplate
	@OneToMany(mappedBy="commodity")
	private List<CargoTemplate> cargoTemplates;

	public Commodity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommodity() {
		return this.commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrimaryQuantity() {
		return this.primaryQuantity;
	}

	public void setPrimaryQuantity(String primaryQuantity) {
		this.primaryQuantity = primaryQuantity;
	}

	public String getScheduleB() {
		return this.scheduleB;
	}

	public void setScheduleB(String scheduleB) {
		this.scheduleB = scheduleB;
	}

	public String getSecondaryQuantity() {
		return this.secondaryQuantity;
	}

	public void setSecondaryQuantity(String secondaryQuantity) {
		this.secondaryQuantity = secondaryQuantity;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo addCargo(Cargo cargo) {
		getCargos().add(cargo);
		cargo.setCommodity(this);

		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setCommodity(null);

		return cargo;
	}

	public List<CargoTemplate> getCargoTemplates() {
		return this.cargoTemplates;
	}

	public void setCargoTemplates(List<CargoTemplate> cargoTemplates) {
		this.cargoTemplates = cargoTemplates;
	}

	public CargoTemplate addCargoTemplate(CargoTemplate cargoTemplate) {
		getCargoTemplates().add(cargoTemplate);
		cargoTemplate.setCommodity(this);

		return cargoTemplate;
	}

	public CargoTemplate removeCargoTemplate(CargoTemplate cargoTemplate) {
		getCargoTemplates().remove(cargoTemplate);
		cargoTemplate.setCommodity(null);

		return cargoTemplate;
	}

}