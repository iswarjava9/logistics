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

import org.hibernate.annotations.Type;


/**
 * The persistent class for the piece_type database table.
 *
 */
@Entity
@Table(name="piece_type")
@NamedQuery(name="PieceType.findAll", query="SELECT p FROM PieceType p")
public class PieceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="bulk_item")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean bulkItem;

	@Column(name="edi_code1")
	private String ediCode1;

	@Column(name="edi_code2")
	private String ediCode2;

	@Column(name="handheld_scanner")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean handheldScanner;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean inactive;

	@Column(name="piece_type")
	private String pieceType;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="pieceType")
	private List<Cargo> cargos;

	public PieceType() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBulkItem() {
		return bulkItem;
	}

	public void setBulkItem(boolean bulkItem) {
		this.bulkItem = bulkItem;
	}

	public String getEdiCode1() {
		return ediCode1;
	}

	public void setEdiCode1(String ediCode1) {
		this.ediCode1 = ediCode1;
	}

	public String getEdiCode2() {
		return ediCode2;
	}

	public void setEdiCode2(String ediCode2) {
		this.ediCode2 = ediCode2;
	}

	public boolean isHandheldScanner() {
		return handheldScanner;
	}

	public void setHandheldScanner(boolean handheldScanner) {
		this.handheldScanner = handheldScanner;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

	public String getPieceType() {
		return pieceType;
	}

	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}