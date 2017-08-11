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


/**
 * The persistent class for the vessel database table.
 *
 */
@Entity
@NamedQuery(name="Vessel.findAll", query="SELECT v FROM Vessel v")
public class Vessel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="`lloyds _code`")
	private String lloyds_Code;

	private String name;

	@Column(name="vessel_no")
	private String vesselNo;

	//bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy="vessel")
	private List<Quotation> quotations;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="flag_id")
	private Country country;

	public Vessel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLloyds_Code() {
		return this.lloyds_Code;
	}

	public void setLloyds_Code(String lloyds_Code) {
		this.lloyds_Code = lloyds_Code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVesselNo() {
		return this.vesselNo;
	}

	public void setVesselNo(String vesselNo) {
		this.vesselNo = vesselNo;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Quotation addQuotation(Quotation quotation) {
		getQuotations().add(quotation);
		quotation.setVessel(this);

		return quotation;
	}

	public Quotation removeQuotation(Quotation quotation) {
		getQuotations().remove(quotation);
		quotation.setVessel(null);

		return quotation;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}