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

/**
 * The persistent class for the commodity database table.
 *
 */
@Entity
@Table(name = "commodity")
@NamedQueries({@NamedQuery(name = "Commodity.findAll", query = "SELECT c FROM Commodity c"),
	@NamedQuery(name = "Commodity.findByName", query = "SELECT c FROM Commodity c where c.name like :name")})
public class Commodity implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	private String				name;
	private String				description;
	@Column(name = "primary_quantity")
	private String				primaryQuantity;
	@Column(name = "schedule_b")
	private String				scheduleB;
	@Column(name = "secondary_quantity")
	private String				secondaryQuantity;

	/*
	 * //bi-directional many-to-one association to Cargo
	 *
	 * @OneToMany(mappedBy="commodity") private List<Cargo> cargos;
	 *
	 * //bi-directional many-to-one association to CargoTemplate
	 *
	 * @OneToOne(mappedBy="commodity") private CargoTemplate cargoTemplates;
	 */
	public Commodity() {
	}

	public int getId() {
		return this.id;
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
}
