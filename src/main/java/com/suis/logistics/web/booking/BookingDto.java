package com.suis.logistics.web.booking;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.user.UserDto;

public class BookingDto {

	private Integer				id;
	private String				aesAuthNo;
	private Integer				bookingPersonId;
	private Integer				bookingStatusId;
	private String				carrierBookingNo;
	private String				carrierContact;
	private Integer				carrierId;
	private String				carrierVoyage;
	private String				controller;
	private Integer				divisionId;
	private Integer				forwarderId;
	private String				forwarderRefNo;
	private String				freight;
	private Integer				lineOfBusinessId;
	private String				nraNumber;
	private String				nvoccBookingNo;
	private Integer				salesRepresentativeId;
	private Integer				serviceContractId;
	private String				shipperRefNo;
	private Integer				typeOfMoveId;
	private Integer				typeOfServiceId;
	private Integer				vesselId;
	//
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		docsCutOffDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		docsReceivedDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		eta;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		bookingDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		cargoMovingDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		cutOffDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		delieveryEta;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		rateCutOffDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		sailDate;
	//
	private ClientDto			client;
	private UserDto				user;
	private CustomerDto			foreignAgent;
	private CustomerDto			account;
	private CustomerDto			consignee;
	private CustomerDto			localSSLineOffice;
	private CustomerDto			notify;
	private CustomerDto			shipper;
	private PlaceDto			loadTerminal;
	private PlaceDto			placeOfDelivery;
	private PlaceDto			placeOfReceipt;
	private PlaceDto			portOfDischarge;
	private PlaceDto			portOfLoad;
	private PlaceDto			transhipmentPort;
	private List<ContainerDto>	containerDetails;

	// getter and setter method
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

	public LocalDateTime getDocsCutOffDateTime() {
		return docsCutOffDateTime;
	}

	public void setDocsCutOffDateTime(LocalDateTime docsCutOffDateTime) {
		this.docsCutOffDateTime = docsCutOffDateTime;
	}

	public LocalDateTime getDocsReceivedDate() {
		return docsReceivedDate;
	}

	public void setDocsReceivedDate(LocalDateTime docsReceivedDate) {
		this.docsReceivedDate = docsReceivedDate;
	}

	public LocalDateTime getEta() {
		return eta;
	}

	public void setEta(LocalDateTime eta) {
		this.eta = eta;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getCargoMovingDate() {
		return cargoMovingDate;
	}

	public void setCargoMovingDate(LocalDateTime cargoMovingDate) {
		this.cargoMovingDate = cargoMovingDate;
	}

	public LocalDateTime getCutOffDate() {
		return cutOffDate;
	}

	public void setCutOffDate(LocalDateTime cutOffDate) {
		this.cutOffDate = cutOffDate;
	}

	public LocalDateTime getDelieveryEta() {
		return delieveryEta;
	}

	public void setDelieveryEta(LocalDateTime delieveryEta) {
		this.delieveryEta = delieveryEta;
	}

	public LocalDateTime getRateCutOffDateTime() {
		return rateCutOffDateTime;
	}

	public void setRateCutOffDateTime(LocalDateTime rateCutOffDateTime) {
		this.rateCutOffDateTime = rateCutOffDateTime;
	}

	public LocalDateTime getSailDate() {
		return sailDate;
	}

	public void setSailDate(LocalDateTime sailDate) {
		this.sailDate = sailDate;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public CustomerDto getForeignAgent() {
		return foreignAgent;
	}

	public void setForeignAgent(CustomerDto foreignAgent) {
		this.foreignAgent = foreignAgent;
	}

	public CustomerDto getAccount() {
		return account;
	}

	public void setAccount(CustomerDto account) {
		this.account = account;
	}

	public CustomerDto getConsignee() {
		return consignee;
	}

	public void setConsignee(CustomerDto consignee) {
		this.consignee = consignee;
	}

	public CustomerDto getLocalSSLineOffice() {
		return localSSLineOffice;
	}

	public void setLocalSSLineOffice(CustomerDto localSSLineOffice) {
		this.localSSLineOffice = localSSLineOffice;
	}

	public CustomerDto getNotify() {
		return notify;
	}

	public void setNotify(CustomerDto notify) {
		this.notify = notify;
	}

	public CustomerDto getShipper() {
		return shipper;
	}

	public void setShipper(CustomerDto shipper) {
		this.shipper = shipper;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public PlaceDto getLoadTerminal() {
		return loadTerminal;
	}

	public void setLoadTerminal(PlaceDto loadTerminal) {
		this.loadTerminal = loadTerminal;
	}

	public PlaceDto getPlaceOfDelivery() {
		return placeOfDelivery;
	}

	public void setPlaceOfDelivery(PlaceDto placeOfDelivery) {
		this.placeOfDelivery = placeOfDelivery;
	}

	public PlaceDto getPlaceOfReceipt() {
		return placeOfReceipt;
	}

	public void setPlaceOfReceipt(PlaceDto placeOfReceipt) {
		this.placeOfReceipt = placeOfReceipt;
	}

	public PlaceDto getPortOfDischarge() {
		return portOfDischarge;
	}

	public void setPortOfDischarge(PlaceDto portOfDischarge) {
		this.portOfDischarge = portOfDischarge;
	}

	public PlaceDto getPortOfLoad() {
		return portOfLoad;
	}

	public void setPortOfLoad(PlaceDto portOfLoad) {
		this.portOfLoad = portOfLoad;
	}

	public PlaceDto getTranshipmentPort() {
		return transhipmentPort;
	}

	public void setTranshipmentPort(PlaceDto transhipmentPort) {
		this.transhipmentPort = transhipmentPort;
	}

	public List<ContainerDto> getContainerDetails() {
		return containerDetails;
	}

	public void setContainerDetails(List<ContainerDto> containerDetails) {
		this.containerDetails = containerDetails;
	}
}
