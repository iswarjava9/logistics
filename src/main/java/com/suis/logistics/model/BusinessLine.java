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
import javax.persistence.Table;


/**
 * The persistent class for the business_line database table.
 *
 */
@Entity
@Table(name="business_line")
@NamedQuery(name="BusinessLine.findAll", query="SELECT b FROM BusinessLine b")
public class BusinessLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="line_of_business")
	private int lineOfBusiness;

	@Column(name="transport_mode")
	private String transportMode;

	@Column(name="transport_type")
	private String transportType;

	//bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy="businessLine")
	private List<Quotation> quotations;

	public BusinessLine() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLineOfBusiness() {
		return this.lineOfBusiness;
	}

	public void setLineOfBusiness(int lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public String getTransportMode() {
		return this.transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public String getTransportType() {
		return this.transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Quotation addQuotation(Quotation quotation) {
		getQuotations().add(quotation);
		quotation.setBusinessLine(this);

		return quotation;
	}

	public Quotation removeQuotation(Quotation quotation) {
		getQuotations().remove(quotation);
		quotation.setBusinessLine(null);

		return quotation;
	}

}