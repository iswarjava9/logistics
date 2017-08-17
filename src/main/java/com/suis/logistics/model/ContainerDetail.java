package com.suis.logistics.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "containerDetail" )
	private List<Cargo> cargos;

	//bi-directional many-to-one association to BookingDetail
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id")
	private BookingDetail bookingDetail;

	//bi-directional many-to-one association to ContainerType
	@ManyToOne
	@JoinColumn(name="container_type_id")
	private ContainerType containerType;

	//bi-directional many-to-one association to Quotation
	@OneToOne
	private Quotation quotation;

	@Column(name="vehicle_no")
	private int vehicleNo;

	@Column(name="stuffing_no")
	private int stuffingNo;

	@Column(name="railway_bill_no")
	private int railwayBillNo;


	@Column(name="pickup_date")
	private LocalDateTime pickupLocalDateTime;


	@Column(name="planned_ship_date")
	private LocalDateTime plannedShipLocalDateTime;


	@Column(name="cus_pickup_last_free_date")
	private LocalDateTime cusPickupLastFreeLocalDateTime;


	@Column(name="cus_return_last_free_date")
	private LocalDateTime cusReturnLastFreeLocalDateTime;


	@Column(name="car_pickup_last_free_date")
	private LocalDateTime carrierPickupLastFreeLocalDateTime;


	@Column(name="car_return_last_free_date")
	private LocalDateTime carrierReturnLastFreeLocalDateTime;


	@Column(name="discharge_date")
	private LocalDateTime dischargeLocalDateTime;

	/*private Integer bookingId;

	private Integer quotationId;*/

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
		cargo.setContainerDetail(this);
		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setContainerDetail(null);

		return cargo;
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

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getStuffingNo() {
		return stuffingNo;
	}

	public void setStuffingNo(int stuffingNo) {
		this.stuffingNo = stuffingNo;
	}

	public int getRailwayBillNo() {
		return railwayBillNo;
	}

	public void setRailwayBillNo(int railwayBillNo) {
		this.railwayBillNo = railwayBillNo;
	}

	public LocalDateTime getPickupLocalDateTime() {
		return pickupLocalDateTime;
	}

	public void setPickupLocalDateTime(LocalDateTime pickupLocalDateTime) {
		this.pickupLocalDateTime = pickupLocalDateTime;
	}

	public LocalDateTime getPlannedShipLocalDateTime() {
		return plannedShipLocalDateTime;
	}

	public void setPlannedShipLocalDateTime(LocalDateTime plannedShipLocalDateTime) {
		this.plannedShipLocalDateTime = plannedShipLocalDateTime;
	}

	public LocalDateTime getCusPickupLastFreeLocalDateTime() {
		return cusPickupLastFreeLocalDateTime;
	}

	public void setCusPickupLastFreeLocalDateTime(LocalDateTime cusPickupLastFreeLocalDateTime) {
		this.cusPickupLastFreeLocalDateTime = cusPickupLastFreeLocalDateTime;
	}

	public LocalDateTime getCusReturnLastFreeLocalDateTime() {
		return cusReturnLastFreeLocalDateTime;
	}

	public void setCusReturnLastFreeLocalDateTime(LocalDateTime cusReturnLastFreeLocalDateTime) {
		this.cusReturnLastFreeLocalDateTime = cusReturnLastFreeLocalDateTime;
	}

	public LocalDateTime getCarrierPickupLastFreeLocalDateTime() {
		return carrierPickupLastFreeLocalDateTime;
	}

	public void setCarrierPickupLastFreeLocalDateTime(LocalDateTime carrierPickupLastFreeLocalDateTime) {
		this.carrierPickupLastFreeLocalDateTime = carrierPickupLastFreeLocalDateTime;
	}

	public LocalDateTime getCarrierReturnLastFreeLocalDateTime() {
		return carrierReturnLastFreeLocalDateTime;
	}

	public void setCarrierReturnLastFreeLocalDateTime(LocalDateTime carrierReturnLastFreeLocalDateTime) {
		this.carrierReturnLastFreeLocalDateTime = carrierReturnLastFreeLocalDateTime;
	}

	public LocalDateTime getDischargeLocalDateTime() {
		return dischargeLocalDateTime;
	}

	public void setDischargeLocalDateTime(LocalDateTime dischargeLocalDateTime) {
		this.dischargeLocalDateTime = dischargeLocalDateTime;
	}

	public BookingDetail getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}


}