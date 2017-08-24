package com.suis.logistics.web.booking;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.suis.logistics.web.businessline.BusinessLineDto;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.division.DivisionDto;
import com.suis.logistics.web.movementtype.MovementTypeDto;
import com.suis.logistics.web.person.PersonDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.user.UserDto;
import com.suis.logistics.web.vessel.VesselDto;


public class BookingDto {

	private Integer				id;
	private String				aesAuthNo;
	private String				bookingStatus;
	private String				carrierBookingNo;
	private String				carrierContact;
	private String				carrierVoyage;
	private String				controller;
	private String				forwarderRefNo;
	private String				freight;
	private String				nraNumber;
	private String				nvoccBookingNo;
	private Integer				serviceContractId;
	private String				shipperRefNo;
	private String				typeOfService;
	//
	//@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
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
	//
	private CustomerDto			forwarder;
	private BusinessLineDto		lineOfBusiness;
	private PersonDto			salesRepresentative;
	private MovementTypeDto		typeOfMove;
	private VesselDto			vessel;
	private PersonDto			bookingPerson;
	private DivisionDto			division;
	private CustomerDto			carrier;

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



	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
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

	public CustomerDto getForwarder() {
		return forwarder;
	}

	public void setForwarder(CustomerDto forwarder) {
		this.forwarder = forwarder;
	}

	public BusinessLineDto getLineOfBusiness() {
		return lineOfBusiness;
	}

	public void setLineOfBusiness(BusinessLineDto lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public PersonDto getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(PersonDto salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public MovementTypeDto getTypeOfMove() {
		return typeOfMove;
	}

	public void setTypeOfMove(MovementTypeDto typeOfMove) {
		this.typeOfMove = typeOfMove;
	}

	public VesselDto getVessel() {
		return vessel;
	}

	public void setVessel(VesselDto vessel) {
		this.vessel = vessel;
	}

	public PersonDto getBookingPerson() {
		return bookingPerson;
	}

	public void setBookingPerson(PersonDto bookingPerson) {
		this.bookingPerson = bookingPerson;
	}

	public DivisionDto getDivision() {
		return division;
	}

	public void setDivision(DivisionDto division) {
		this.division = division;
	}


	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
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

	public CustomerDto getCarrier() {
		return carrier;
	}

	public void setCarrier(CustomerDto carrier) {
		this.carrier = carrier;
	}


}
