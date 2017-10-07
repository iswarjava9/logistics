package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.suis.logistics.model.BookingDetail;


/**
 * The persistent class for the bill_of_lading database table.
 *
 */
@Entity
@Table(name="bill_of_lading")
@NamedQuery(name="BillOfLading.findAll", query="SELECT b FROM BillOfLading b")
public class BillOfLading implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="bl_no")
	private String blNo;

	@Column(name="cargo_description")
	private String cargoDescription;

	@Column(name="carrier_ref_no")
	private String carrierRefNo;

	@Column(name="coloaded_with")
	private String coloadedWith;

	private String consignee;

	@Column(name="cosolidation_no")
	private String cosolidationNo;

	@Column(name="delievery_agent")
	private String delieveryAgent;

	@Column(name="export_reference")
	private String exportReference;

	@Column(name="forwarding_agent")
	private String forwardingAgent;

	@Column(name="ftz_no")
	private String ftzNo;

	@Column(name="ingate_at_terminal")
	private String ingateAtTerminal;

	@Column(name="mbl_no")
	private String mblNo;

	private String notify;

	@Column(name="place_of_delivery")
	private String placeOfDelivery;

	@Column(name="place_of_receipt")
	private String placeOfReceipt;

	@Column(name="port_of_discharge")
	private String portOfDischarge;

	@Column(name="port_of_load")
	private String portOfLoad;

	@Column(name="precarriage_by")
	private String precarriageBy;

	private String shipper;

	@Column(name="shipper_ref")
	private String shipperRef;

	@Column(name="vessel_voyage")
	private String vesselVoyage;


	@OneToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	public BillOfLading() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlNo() {
		return this.blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCargoDescription() {
		return this.cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public String getCarrierRefNo() {
		return this.carrierRefNo;
	}

	public void setCarrierRefNo(String carrierRefNo) {
		this.carrierRefNo = carrierRefNo;
	}

	public String getColoadedWith() {
		return this.coloadedWith;
	}

	public void setColoadedWith(String coloadedWith) {
		this.coloadedWith = coloadedWith;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getCosolidationNo() {
		return this.cosolidationNo;
	}

	public void setCosolidationNo(String cosolidationNo) {
		this.cosolidationNo = cosolidationNo;
	}

	public String getDelieveryAgent() {
		return this.delieveryAgent;
	}

	public void setDelieveryAgent(String delieveryAgent) {
		this.delieveryAgent = delieveryAgent;
	}

	public String getExportReference() {
		return this.exportReference;
	}

	public void setExportReference(String exportReference) {
		this.exportReference = exportReference;
	}

	public String getForwardingAgent() {
		return this.forwardingAgent;
	}

	public void setForwardingAgent(String forwardingAgent) {
		this.forwardingAgent = forwardingAgent;
	}

	public String getFtzNo() {
		return this.ftzNo;
	}

	public void setFtzNo(String ftzNo) {
		this.ftzNo = ftzNo;
	}

	public String getIngateAtTerminal() {
		return this.ingateAtTerminal;
	}

	public void setIngateAtTerminal(String ingateAtTerminal) {
		this.ingateAtTerminal = ingateAtTerminal;
	}

	public String getMblNo() {
		return this.mblNo;
	}

	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}

	public String getNotify() {
		return this.notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getPlaceOfDelivery() {
		return this.placeOfDelivery;
	}

	public void setPlaceOfDelivery(String placeOfDelivery) {
		this.placeOfDelivery = placeOfDelivery;
	}

	public String getPlaceOfReceipt() {
		return this.placeOfReceipt;
	}

	public void setPlaceOfReceipt(String placeOfReceipt) {
		this.placeOfReceipt = placeOfReceipt;
	}

	public String getPortOfDischarge() {
		return this.portOfDischarge;
	}

	public void setPortOfDischarge(String portOfDischarge) {
		this.portOfDischarge = portOfDischarge;
	}

	public String getPortOfLoad() {
		return this.portOfLoad;
	}

	public void setPortOfLoad(String portOfLoad) {
		this.portOfLoad = portOfLoad;
	}

	public String getPrecarriageBy() {
		return this.precarriageBy;
	}

	public void setPrecarriageBy(String precarriageBy) {
		this.precarriageBy = precarriageBy;
	}

	public String getShipper() {
		return this.shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getShipperRef() {
		return this.shipperRef;
	}

	public void setShipperRef(String shipperRef) {
		this.shipperRef = shipperRef;
	}

	public String getVesselVoyage() {
		return this.vesselVoyage;
	}

	public void setVesselVoyage(String vesselVoyage) {
		this.vesselVoyage = vesselVoyage;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

}