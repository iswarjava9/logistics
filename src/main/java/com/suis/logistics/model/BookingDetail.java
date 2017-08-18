package com.suis.logistics.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the booking_detail database table.
 *
 */
@Entity
@Table(name = "booking_detail")
@NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b")
public class BookingDetail implements Serializable {

	private static final long		serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer					id;
	@Column(name = "aes_auth_no")
	private String					aesAuthNo;
	@Column(name = "booking_status")
	private String					bookingStatus;
	@Column(name = "carrier_booking_no")
	private String					carrierBookingNo;
	@Column(name = "carrier_contact")
	private String					carrierContact;
	@Column(name = "carrier_voyage")
	private String					carrierVoyage;
	private String					controller;
	@Column(name = "forwarder_ref_no")
	private String					forwarderRefNo;
	private String					freight;
	@Column(name = "type_of_service")
	private String					typeOfService;
	@Column(name = "nra_number")
	private String					nraNumber;
	@Column(name = "nvocc_booking_no")
	private String					nvoccBookingNo;
	@Column(name = "service_contract_id")
	private Integer					serviceContractId;
	@Column(name = "shipper_ref_no")
	private String					shipperRefNo;
	//
	@Column(name = "docs_cut_off_date_time")
	private LocalDateTime			docsCutOffDateTime;
	@Column(name = "docs_received_date")
	private LocalDateTime			docsReceivedDate;
	private LocalDateTime			eta;
	@Column(name = "booking_date")
	private LocalDateTime			bookingDate;
	@Column(name = "cargo_moving_date")
	private LocalDateTime			cargoMovingDate;
	@Column(name = "cut_off_date")
	private LocalDateTime			cutOffDate;
	@Column(name = "delievery_eta")
	private LocalDateTime			delieveryEta;
	@Column(name = "rate_cut_off_date_time")
	private LocalDateTime			rateCutOffDateTime;
	@Column(name = "sail_date")
	private LocalDateTime			sailDate;
	//
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client					client;
	@OneToOne
	@JoinColumn(name = "forwarder_id")
	private Customer				forwarder;
	@OneToOne
	@JoinColumn(name = "line_of_business_id")
	private BusinessLine			lineOfBusiness;
	@OneToOne
	@JoinColumn(name = "sales_representative_id")
	private Person					salesRepresentative;
	@OneToOne
	@JoinColumn(name = "type_of_move_id")
	private MovementType			typeOfMove;
	@OneToOne
	@JoinColumn(name = "vessel_id")
	private Vessel					vessel;
	@OneToOne
	@JoinColumn(name = "booking_person_id")
	private Person					bookingPerson;

	@OneToOne
	@JoinColumn(name = "division_id")
	private Division				division;
	@OneToOne
	@JoinColumn(name = "carrier_id")
	private Place					carrier;
	@OneToOne
	@JoinColumn(name = "foreign_agent_id")
	private Customer				foreignAgent;
	@OneToOne
	@JoinColumn(name = "account_id")
	private Customer				account;
	@OneToOne
	@JoinColumn(name = "consignee_id")
	private Customer				consignee;
	@OneToOne
	@JoinColumn(name = "local_ss_line_office_id")
	private Customer				localSSLineOffice;
	@OneToOne
	@JoinColumn(name = "notify_id")
	private Customer				notify;
	@OneToOne
	@JoinColumn(name = "shipper_id")
	private Customer				shipper;
	@OneToOne
	private User					user;
	@OneToOne
	@JoinColumn(name = "load_terminal_id")
	private Place					loadTerminal;
	@OneToOne
	@JoinColumn(name = "place_of_delivery_id")
	private Place					placeOfDelivery;
	@OneToOne
	@JoinColumn(name = "place_of_receipt_id")
	private Place					placeOfReceipt;
	@OneToOne
	@JoinColumn(name = "port_of_discharge_id")
	private Place					portOfDischarge;
	@OneToOne
	@JoinColumn(name = "port_of_load_id")
	private Place					portOfLoad;
	@OneToOne
	@JoinColumn(name = "transhipment_port_id")
	private Place					transhipmentPort;
	@OneToMany(mappedBy = "bookingDetail")
	private List<ContainerDetail>	containerDetails;

	public BookingDetail() {
	}

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

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
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

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Customer getForwarder() {
		return forwarder;
	}

	public void setForwarder(Customer forwarder) {
		this.forwarder = forwarder;
	}

	public BusinessLine getLineOfBusiness() {
		return lineOfBusiness;
	}

	public void setLineOfBusiness(BusinessLine lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public Person getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(Person salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public MovementType getTypeOfMove() {
		return typeOfMove;
	}

	public void setTypeOfMove(MovementType typeOfMove) {
		this.typeOfMove = typeOfMove;
	}

	public Vessel getVessel() {
		return vessel;
	}

	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}

	public Person getBookingPerson() {
		return bookingPerson;
	}

	public void setBookingPerson(Person bookingPerson) {
		this.bookingPerson = bookingPerson;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Place getCarrier() {
		return carrier;
	}

	public void setCarrier(Place carrier) {
		this.carrier = carrier;
	}

	public Customer getForeignAgent() {
		return foreignAgent;
	}

	public void setForeignAgent(Customer foreignAgent) {
		this.foreignAgent = foreignAgent;
	}

	public Customer getAccount() {
		return account;
	}

	public void setAccount(Customer account) {
		this.account = account;
	}

	public Customer getConsignee() {
		return consignee;
	}

	public void setConsignee(Customer consignee) {
		this.consignee = consignee;
	}

	public Customer getLocalSSLineOffice() {
		return localSSLineOffice;
	}

	public void setLocalSSLineOffice(Customer localSSLineOffice) {
		this.localSSLineOffice = localSSLineOffice;
	}

	public Customer getNotify() {
		return notify;
	}

	public void setNotify(Customer notify) {
		this.notify = notify;
	}

	public Customer getShipper() {
		return shipper;
	}

	public void setShipper(Customer shipper) {
		this.shipper = shipper;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Place getLoadTerminal() {
		return loadTerminal;
	}

	public void setLoadTerminal(Place loadTerminal) {
		this.loadTerminal = loadTerminal;
	}

	public Place getPlaceOfDelivery() {
		return placeOfDelivery;
	}

	public void setPlaceOfDelivery(Place placeOfDelivery) {
		this.placeOfDelivery = placeOfDelivery;
	}

	public Place getPlaceOfReceipt() {
		return placeOfReceipt;
	}

	public void setPlaceOfReceipt(Place placeOfReceipt) {
		this.placeOfReceipt = placeOfReceipt;
	}

	public Place getPortOfDischarge() {
		return portOfDischarge;
	}

	public void setPortOfDischarge(Place portOfDischarge) {
		this.portOfDischarge = portOfDischarge;
	}

	public Place getPortOfLoad() {
		return portOfLoad;
	}

	public void setPortOfLoad(Place portOfLoad) {
		this.portOfLoad = portOfLoad;
	}

	public Place getTranshipmentPort() {
		return transhipmentPort;
	}

	public void setTranshipmentPort(Place transhipmentPort) {
		this.transhipmentPort = transhipmentPort;
	}

	public List<ContainerDetail> getContainerDetails() {
		return containerDetails;
	}

	public void setContainerDetails(List<ContainerDetail> containerDetails) {
		this.containerDetails = containerDetails;
	}


}
