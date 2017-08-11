package com.suis.logistics.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cargo_template database table.
 *
 */
@Entity
@Table(name="cargo_template")
@NamedQuery(name="CargoTemplate.findAll", query="SELECT c FROM CargoTemplate c")
public class CargoTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="cargo_no")
	private String cargoNo;

	private String description;

	@Column(name="hts_id")
	private int htsId;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="cargoTemplate")
	private List<Cargo> cargos;

	//bi-directional many-to-one association to Commodity
	@ManyToOne
	@JoinColumn(name="schedule_b_id")
	private Commodity commodity;

	public CargoTemplate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargoNo() {
		return this.cargoNo;
	}

	public void setCargoNo(String cargoNo) {
		this.cargoNo = cargoNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHtsId() {
		return this.htsId;
	}

	public void setHtsId(int htsId) {
		this.htsId = htsId;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo addCargo(Cargo cargo) {
		getCargos().add(cargo);
		cargo.setCargoTemplate(this);

		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setCargoTemplate(null);

		return cargo;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

}