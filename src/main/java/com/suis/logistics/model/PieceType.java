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
	private byte bulkItem;

	@Column(name="edi_code1")
	private String ediCode1;

	@Column(name="edi_code2")
	private String ediCode2;

	@Column(name="handheld_scanner")
	private byte handheldScanner;

	private byte inactive;

	@Column(name="piece_type")
	private String pieceType;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="pieceType")
	private List<Cargo> cargos;

	public PieceType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getBulkItem() {
		return this.bulkItem;
	}

	public void setBulkItem(byte bulkItem) {
		this.bulkItem = bulkItem;
	}

	public String getEdiCode1() {
		return this.ediCode1;
	}

	public void setEdiCode1(String ediCode1) {
		this.ediCode1 = ediCode1;
	}

	public String getEdiCode2() {
		return this.ediCode2;
	}

	public void setEdiCode2(String ediCode2) {
		this.ediCode2 = ediCode2;
	}

	public byte getHandheldScanner() {
		return this.handheldScanner;
	}

	public void setHandheldScanner(byte handheldScanner) {
		this.handheldScanner = handheldScanner;
	}

	public byte getInactive() {
		return this.inactive;
	}

	public void setInactive(byte inactive) {
		this.inactive = inactive;
	}

	public String getPieceType() {
		return this.pieceType;
	}

	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo addCargo(Cargo cargo) {
		getCargos().add(cargo);
		cargo.setPieceType(this);

		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setPieceType(null);

		return cargo;
	}

}