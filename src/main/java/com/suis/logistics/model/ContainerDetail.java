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
 * The persistent class for the container_detail database table.
 *
 */
@Entity
@Table(name="container_detail")
@NamedQuery(name="ContainerDetail.findAll", query="SELECT c FROM ContainerDetail c")
public class ContainerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="container_no")
	private String containerNo;

	private String equipment;

	@Column(name="gross_kgs")
	private double grossKgs;

	@Column(name="gross_lbs")
	private double grossLbs;

	private String seal1;

	private String seal2;

	private String seal3;

	@Column(name="tare_kgs")
	private double tareKgs;

	@Column(name="tare_lbs")
	private double tareLbs;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="containerDetail")
	private List<Cargo> cargos;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	//bi-directional many-to-one association to ContainerType
	@ManyToOne
	@JoinColumn(name="container_type_id")
	private ContainerType containerType;

	//bi-directional many-to-one association to Quotation
	@ManyToOne
	private Quotation quotation;

	public ContainerDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContainerNo() {
		return this.containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public String getEquipment() {
		return this.equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public double getGrossKgs() {
		return this.grossKgs;
	}

	public void setGrossKgs(double grossKgs) {
		this.grossKgs = grossKgs;
	}

	public double getGrossLbs() {
		return this.grossLbs;
	}

	public void setGrossLbs(double grossLbs) {
		this.grossLbs = grossLbs;
	}

	public String getSeal1() {
		return this.seal1;
	}

	public void setSeal1(String seal1) {
		this.seal1 = seal1;
	}

	public String getSeal2() {
		return this.seal2;
	}

	public void setSeal2(String seal2) {
		this.seal2 = seal2;
	}

	public String getSeal3() {
		return this.seal3;
	}

	public void setSeal3(String seal3) {
		this.seal3 = seal3;
	}

	public double getTareKgs() {
		return this.tareKgs;
	}

	public void setTareKgs(double tareKgs) {
		this.tareKgs = tareKgs;
	}

	public double getTareLbs() {
		return this.tareLbs;
	}

	public void setTareLbs(double tareLbs) {
		this.tareLbs = tareLbs;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo addCargo(Cargo cargo) {
		getCargos().add(cargo);
		cargo.setContainerDetail(this);

		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setContainerDetail(null);

		return cargo;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public ContainerType getContainerType() {
		return this.containerType;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public Quotation getQuotation() {
		return this.quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

}