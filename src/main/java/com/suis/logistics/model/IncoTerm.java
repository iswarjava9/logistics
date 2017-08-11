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
 * The persistent class for the inco_term database table.
 *
 */
@Entity
@Table(name="inco_term")
@NamedQuery(name="IncoTerm.findAll", query="SELECT i FROM IncoTerm i")
public class IncoTerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="inco_term")
	private String incoTerm;

	//bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy="incoTerm")
	private List<Quotation> quotations;

	public IncoTerm() {
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

	public String getIncoTerm() {
		return this.incoTerm;
	}

	public void setIncoTerm(String incoTerm) {
		this.incoTerm = incoTerm;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Quotation addQuotation(Quotation quotation) {
		getQuotations().add(quotation);
		quotation.setIncoTerm(this);

		return quotation;
	}

	public Quotation removeQuotation(Quotation quotation) {
		getQuotations().remove(quotation);
		quotation.setIncoTerm(null);

		return quotation;
	}

}