package com.suis.logistics.web.billoflading;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suis.logistics.web.booking.BookingDto;

public class BillOfLadingDto {

	private int id;
	private String blNo;
	private String cargoDescription;
	private String carrierRefNo;
	private String coloadedWith;
	private String consignee;
	private String cosolidationNo;
	private String delieveryAgent;
	private String exportReference;
	private String forwardingAgent;
	private String ftzNo;
	private String ingateAtTerminal;
	private String mblNo;
	private String notify;
	private String placeOfDelivery;
	private String placeOfReceipt;
	private String portOfDischarge;
	private String portOfLoad;
	private String precarriageBy;
	private String shipper;
	private String shipperRef;
	private String vesselVoyage;
	
	private BookingDto	bookingDetail;
	
	

	public BookingDto getBookingDetail() {
		return bookingDetail;
	}
	public void setBookingDetail(BookingDto bookingDetail) {
		this.bookingDetail = bookingDetail;
	}
	
	@JsonIgnore
	@Value("${logo.image.url}")
	private String					logoPath;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getCargoDescription() {
		return cargoDescription;
	}
	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}
	public String getCarrierRefNo() {
		return carrierRefNo;
	}
	public void setCarrierRefNo(String carrierRefNo) {
		this.carrierRefNo = carrierRefNo;
	}
	public String getColoadedWith() {
		return coloadedWith;
	}
	public void setColoadedWith(String coloadedWith) {
		this.coloadedWith = coloadedWith;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getCosolidationNo() {
		return cosolidationNo;
	}
	public void setCosolidationNo(String cosolidationNo) {
		this.cosolidationNo = cosolidationNo;
	}
	public String getDelieveryAgent() {
		return delieveryAgent;
	}
	public void setDelieveryAgent(String delieveryAgent) {
		this.delieveryAgent = delieveryAgent;
	}
	public String getExportReference() {
		return exportReference;
	}
	public void setExportReference(String exportReference) {
		this.exportReference = exportReference;
	}
	public String getForwardingAgent() {
		return forwardingAgent;
	}
	public void setForwardingAgent(String forwardingAgent) {
		this.forwardingAgent = forwardingAgent;
	}
	public String getFtzNo() {
		return ftzNo;
	}
	public void setFtzNo(String ftzNo) {
		this.ftzNo = ftzNo;
	}
	public String getIngateAtTerminal() {
		return ingateAtTerminal;
	}
	public void setIngateAtTerminal(String ingateAtTerminal) {
		this.ingateAtTerminal = ingateAtTerminal;
	}
	public String getMblNo() {
		return mblNo;
	}
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
	public String getPlaceOfDelivery() {
		return placeOfDelivery;
	}
	public void setPlaceOfDelivery(String placeOfDelivery) {
		this.placeOfDelivery = placeOfDelivery;
	}
	public String getPlaceOfReceipt() {
		return placeOfReceipt;
	}
	public void setPlaceOfReceipt(String placeOfReceipt) {
		this.placeOfReceipt = placeOfReceipt;
	}
	public String getPortOfDischarge() {
		return portOfDischarge;
	}
	public void setPortOfDischarge(String portOfDischarge) {
		this.portOfDischarge = portOfDischarge;
	}
	public String getPortOfLoad() {
		return portOfLoad;
	}
	public void setPortOfLoad(String portOfLoad) {
		this.portOfLoad = portOfLoad;
	}
	public String getPrecarriageBy() {
		return precarriageBy;
	}
	public void setPrecarriageBy(String precarriageBy) {
		this.precarriageBy = precarriageBy;
	}
	public String getShipper() {
		return shipper;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public String getShipperRef() {
		return shipperRef;
	}
	public void setShipperRef(String shipperRef) {
		this.shipperRef = shipperRef;
	}
	public String getVesselVoyage() {
		return vesselVoyage;
	}
	public void setVesselVoyage(String vesselVoyage) {
		this.vesselVoyage = vesselVoyage;
	}
	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

}
