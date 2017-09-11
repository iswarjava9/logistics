package com.suis.logistics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@NamedQueries({ @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
		@NamedQuery(name = "City.findByName", query = "SELECT c FROM City c where c.name like :name") })
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int		id;
	private String	name;
	@ManyToOne
	private State	state;

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
