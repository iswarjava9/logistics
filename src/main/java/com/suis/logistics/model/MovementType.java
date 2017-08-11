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
 * The persistent class for the movement_type database table.
 *
 */
@Entity
@Table(name="movement_type")
@NamedQuery(name="MovementType.findAll", query="SELECT m FROM MovementType m")
public class MovementType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="edi_code")
	private String ediCode;

	@Column(name="moves_end")
	private String movesEnd;

	@Column(name="moves_start")
	private String movesStart;

	@Column(name="type_of_service")
	private String typeOfService;

	//bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy="movementType")
	private List<Quotation> quotations;

	public MovementType() {
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

	public String getEdiCode() {
		return this.ediCode;
	}

	public void setEdiCode(String ediCode) {
		this.ediCode = ediCode;
	}

	public String getMovesEnd() {
		return this.movesEnd;
	}

	public void setMovesEnd(String movesEnd) {
		this.movesEnd = movesEnd;
	}

	public String getMovesStart() {
		return this.movesStart;
	}

	public void setMovesStart(String movesStart) {
		this.movesStart = movesStart;
	}

	public String getTypeOfService() {
		return this.typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Quotation addQuotation(Quotation quotation) {
		getQuotations().add(quotation);
		quotation.setMovementType(this);

		return quotation;
	}

	public Quotation removeQuotation(Quotation quotation) {
		getQuotations().remove(quotation);
		quotation.setMovementType(null);

		return quotation;
	}

}