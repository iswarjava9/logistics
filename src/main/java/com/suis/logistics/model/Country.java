package com.suis.logistics.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the country database table.
 *
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy="country")
	private List<Quotation> quotations;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="country")
	private List<State> states;

	//bi-directional many-to-one association to Vessel
	@OneToMany(mappedBy="country")
	private List<Vessel> vessels;

	public Country() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Quotation addQuotation(Quotation quotation) {
		getQuotations().add(quotation);
		quotation.setCountry(this);

		return quotation;
	}

	public Quotation removeQuotation(Quotation quotation) {
		getQuotations().remove(quotation);
		quotation.setCountry(null);

		return quotation;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setCountry(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setCountry(null);

		return state;
	}

	public List<Vessel> getVessels() {
		return this.vessels;
	}

	public void setVessels(List<Vessel> vessels) {
		this.vessels = vessels;
	}

	public Vessel addVessel(Vessel vessel) {
		getVessels().add(vessel);
		vessel.setCountry(this);

		return vessel;
	}

	public Vessel removeVessel(Vessel vessel) {
		getVessels().remove(vessel);
		vessel.setCountry(null);

		return vessel;
	}

}