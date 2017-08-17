package com.suis.logistics.web.booking;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.customer.AccountShortInfo;
import com.suis.logistics.web.customer.ConsigneeShortInfo;
import com.suis.logistics.web.customer.ForeignAgentShortInfo;
import com.suis.logistics.web.customer.LocalSSLineShortInfo;
import com.suis.logistics.web.customer.NotifyShortInfo;
import com.suis.logistics.web.customer.ShipperShortInfo;
import com.suis.logistics.web.place.LoadTerminalShortInfo;
import com.suis.logistics.web.place.PlaceOfDeliveryShortInfo;
import com.suis.logistics.web.place.PlaceOfReceiptShortInfo;
import com.suis.logistics.web.place.PortOfDischargeShortInfo;
import com.suis.logistics.web.place.PortOfLoadShortInfo;
import com.suis.logistics.web.place.TranshipmentPortShortInfo;

public class BookingDto {

	private Integer						id;
	private String						aesAuthNo;
	private Integer						bookingPersonId;
	private Integer						bookingStatusId;
	private String						carrierBookingNo;
	private String						carrierContact;
	private Integer						carrierId;
	private String						carrierVoyage;
	private String						controller;
	private Integer						divisionId;
	private Integer						forwarderId;
	private String						forwarderRefNo;
	private String						freight;
	private Integer						lineOfBusinessId;
	private String						nraNumber;
	private String						nvoccBookingNo;
	private Integer						salesRepresentativeId;
	private Integer						serviceContractId;
	private String						shipperRefNo;
	private Integer						typeOfMoveId;
	private Integer						typeOfServiceId;
	private Integer						vesselId;
	private Integer						clientId;
	private Integer						userId;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime						docsCutOffDateTime;
	private Date						rateCutOffDateTime;
	private Date						docsReceivedDate;
	private Date						eta;
	private Date						sailDate;
	private Date						cutOffDate;
	private Date						delieveryEta;
	private Date						cargoMovingDate;
	private Date						bookingDate;

	private ForeignAgentShortInfo		foreignAgentShortInfo;
	private AccountShortInfo			accountShortInfo;
	private ConsigneeShortInfo			consigneeShortInfo;
	private LocalSSLineShortInfo		localSSLineOfficeShortInfo;
	private NotifyShortInfo				notifyShortInfo;
	private ShipperShortInfo			shipperShortInfo;
	private LoadTerminalShortInfo		loadTerminalShortInfo;
	private PlaceOfDeliveryShortInfo	placeOfDeliveryShortInfo;
	private PlaceOfReceiptShortInfo		placeOfReceiptShortInfo;
	private PortOfDischargeShortInfo	portOfDischargeShortInfo;
	private PortOfLoadShortInfo			portOfLoadShortInfo;
	private TranshipmentPortShortInfo	transhipmentPortShortInfo;

	private ContainerDto containerDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAesAuthNo() {
		return aesAuthNo;
	}

	public void setAesAuthNo(String aesAuthNo) {
		this.aesAuthNo = aesAuthNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getBookingPersonId() {
		return bookingPersonId;
	}

	public void setBookingPersonId(Integer bookingPersonId) {
		this.bookingPersonId = bookingPersonId;
	}

	public Integer getBookingStatusId() {
		return bookingStatusId;
	}

	public void setBookingStatusId(Integer bookingStatusId) {
		this.bookingStatusId = bookingStatusId;
	}

	public Date getCargoMovingDate() {
		return cargoMovingDate;
	}

	public void setCargoMovingDate(Date cargoMovingDate) {
		this.cargoMovingDate = cargoMovingDate;
	}

	public String getCarrierBookingNo() {
		return carrierBookingNo;
	}

	public void setCarrierBookingNo(String carrierBookingNo) {
		this.carrierBookingNo = carrierBookingNo;
	}

	public String getCarrierContact() {
		return carrierContact;
	}

	public void setCarrierContact(String carrierContact) {
		this.carrierContact = carrierContact;
	}

	public Integer getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(Integer carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierVoyage() {
		return carrierVoyage;
	}

	public void setCarrierVoyage(String carrierVoyage) {
		this.carrierVoyage = carrierVoyage;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getForwarderId() {
		return forwarderId;
	}

	public void setForwarderId(Integer forwarderId) {
		this.forwarderId = forwarderId;
	}

	public String getForwarderRefNo() {
		return forwarderRefNo;
	}

	public void setForwarderRefNo(String forwarderRefNo) {
		this.forwarderRefNo = forwarderRefNo;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public Integer getLineOfBusinessId() {
		return lineOfBusinessId;
	}

	public void setLineOfBusinessId(Integer lineOfBusinessId) {
		this.lineOfBusinessId = lineOfBusinessId;
	}

	public String getNraNumber() {
		return nraNumber;
	}

	public void setNraNumber(String nraNumber) {
		this.nraNumber = nraNumber;
	}

	public String getNvoccBookingNo() {
		return nvoccBookingNo;
	}

	public void setNvoccBookingNo(String nvoccBookingNo) {
		this.nvoccBookingNo = nvoccBookingNo;
	}

	public Integer getSalesRepresentativeId() {
		return salesRepresentativeId;
	}

	public void setSalesRepresentativeId(Integer salesRepresentativeId) {
		this.salesRepresentativeId = salesRepresentativeId;
	}

	public Integer getServiceContractId() {
		return serviceContractId;
	}

	public void setServiceContractId(Integer serviceContractId) {
		this.serviceContractId = serviceContractId;
	}

	public String getShipperRefNo() {
		return shipperRefNo;
	}

	public void setShipperRefNo(String shipperRefNo) {
		this.shipperRefNo = shipperRefNo;
	}

	public Integer getTypeOfMoveId() {
		return typeOfMoveId;
	}

	public void setTypeOfMoveId(Integer typeOfMoveId) {
		this.typeOfMoveId = typeOfMoveId;
	}

	public Integer getTypeOfServiceId() {
		return typeOfServiceId;
	}

	public void setTypeOfServiceId(Integer typeOfServiceId) {
		this.typeOfServiceId = typeOfServiceId;
	}

	public Integer getVesselId() {
		return vesselId;
	}

	public void setVesselId(Integer vesselId) {
		this.vesselId = vesselId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getDocsCutOffDateTime() {
		return docsCutOffDateTime;
	}

	public void setDocsCutOffDateTime(LocalDateTime docsCutOffDateTime) {
		this.docsCutOffDateTime = docsCutOffDateTime;
	}

	public Date getDocsReceivedDate() {
		return docsReceivedDate;
	}

	public void setDocsReceivedDate(Date docsReceivedDate) {
		this.docsReceivedDate = docsReceivedDate;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Date getRateCutOffDateTime() {
		return rateCutOffDateTime;
	}

	public void setRateCutOffDateTime(Date rateCutOffDateTime) {
		this.rateCutOffDateTime = rateCutOffDateTime;
	}

	public Date getSailDate() {
		return sailDate;
	}

	public void setSailDate(Date sailDate) {
		this.sailDate = sailDate;
	}

	public Date getCutOffDate() {
		return cutOffDate;
	}

	public void setCutOffDate(Date cutOffDate) {
		this.cutOffDate = cutOffDate;
	}

	public Date getDelieveryEta() {
		return delieveryEta;
	}

	public void setDelieveryEta(Date delieveryEta) {
		this.delieveryEta = delieveryEta;
	}

	public ForeignAgentShortInfo getForeignAgentShortInfo() {
		return foreignAgentShortInfo;
	}

	public void setForeignAgentShortInfo(ForeignAgentShortInfo foreignAgentShortInfo) {
		this.foreignAgentShortInfo = foreignAgentShortInfo;
	}

	public AccountShortInfo getAccountShortInfo() {
		return accountShortInfo;
	}

	public void setAccountShortInfo(AccountShortInfo accountShortInfo) {
		this.accountShortInfo = accountShortInfo;
	}

	public ConsigneeShortInfo getConsigneeShortInfo() {
		return consigneeShortInfo;
	}

	public void setConsigneeShortInfo(ConsigneeShortInfo consigneeShortInfo) {
		this.consigneeShortInfo = consigneeShortInfo;
	}

	public LocalSSLineShortInfo getLocalSSLineOfficeShortInfo() {
		return localSSLineOfficeShortInfo;
	}

	public void setLocalSSLineOfficeShortInfo(LocalSSLineShortInfo localSSLineOfficeShortInfo) {
		this.localSSLineOfficeShortInfo = localSSLineOfficeShortInfo;
	}

	public NotifyShortInfo getNotifyShortInfo() {
		return notifyShortInfo;
	}

	public void setNotifyShortInfo(NotifyShortInfo notifyShortInfo) {
		this.notifyShortInfo = notifyShortInfo;
	}

	public ShipperShortInfo getShipperShortInfo() {
		return shipperShortInfo;
	}

	public void setShipperShortInfo(ShipperShortInfo shipperShortInfo) {
		this.shipperShortInfo = shipperShortInfo;
	}

	public LoadTerminalShortInfo getLoadTerminalShortInfo() {
		return loadTerminalShortInfo;
	}

	public void setLoadTerminalShortInfo(LoadTerminalShortInfo loadTerminalShortInfo) {
		this.loadTerminalShortInfo = loadTerminalShortInfo;
	}

	public PlaceOfDeliveryShortInfo getPlaceOfDeliveryShortInfo() {
		return placeOfDeliveryShortInfo;
	}

	public void setPlaceOfDeliveryShortInfo(PlaceOfDeliveryShortInfo placeOfDeliveryShortInfo) {
		this.placeOfDeliveryShortInfo = placeOfDeliveryShortInfo;
	}

	public PlaceOfReceiptShortInfo getPlaceOfReceiptShortInfo() {
		return placeOfReceiptShortInfo;
	}

	public void setPlaceOfReceiptShortInfo(PlaceOfReceiptShortInfo placeOfReceiptShortInfo) {
		this.placeOfReceiptShortInfo = placeOfReceiptShortInfo;
	}

	public PortOfDischargeShortInfo getPortOfDischargeShortInfo() {
		return portOfDischargeShortInfo;
	}

	public void setPortOfDischargeShortInfo(PortOfDischargeShortInfo portOfDischargeShortInfo) {
		this.portOfDischargeShortInfo = portOfDischargeShortInfo;
	}

	public PortOfLoadShortInfo getPortOfLoadShortInfo() {
		return portOfLoadShortInfo;
	}

	public void setPortOfLoadShortInfo(PortOfLoadShortInfo portOfLoadShortInfo) {
		this.portOfLoadShortInfo = portOfLoadShortInfo;
	}

	public TranshipmentPortShortInfo getTranshipmentPortShortInfo() {
		return transhipmentPortShortInfo;
	}

	public void setTranshipmentPortShortInfo(TranshipmentPortShortInfo transhipmentPortShortInfo) {
		this.transhipmentPortShortInfo = transhipmentPortShortInfo;
	}

	public ContainerDto getContainerDetail() {
		return containerDetail;
	}

	public void setContainerDetail(ContainerDto containerDetail) {
		this.containerDetail = containerDetail;
	}

}
