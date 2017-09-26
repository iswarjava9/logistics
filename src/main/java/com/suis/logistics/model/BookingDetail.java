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
import javax.persistence.NamedQueries;
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
@NamedQueries({ @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b"),
		@NamedQuery(name = "BookingDetail.findLastPrimaryKey", query = "SELECT max( b.id ) FROM BookingDetail b") })
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
	@Column(name = "remarks")
	private String					remarks;
	//
	@Column(name = "docs_cut_off_date_time")
	private LocalDateTime			docsCutOffDateTime;
	@Column(name = "docs_received_date")
	private LocalDateTime			docsReceivedDate;
	private LocalDateTime			eta;
	@Column(name = "booking_date")
	private LocalDateTime			bookingDate;
	@Column(name = "amendment_date")
	private LocalDateTime			amendmentDate;
	@Column(name = "cargo_moving_date")
	private LocalDateTime			cargoMovingDate;
	@Column(name = "cut_off_date")
	private LocalDateTime			portCutOffDate;
	@Column(name = "delievery_eta")
	private LocalDateTime			delieveryEta;
	@Column(name = "rail_cut_off_date_time")
	private LocalDateTime			railCutOffDateTime;
	@Column(name = "sail_date")
	private LocalDateTime			sailDate;
	@Column(name = "empty_pickup_date")
	private LocalDateTime			emptyPickupDate;
	@Column(name = "early_receiving_date")
	private LocalDateTime			earlyReceivingDate;
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
	private Customer				carrier;
	@OneToOne
	@JoinColumn(name = "delivery_agent_id")
	private Customer				deliveryAgent;
	@OneToOne
	@JoinColumn(name = "booking_agent_id")
	private Customer				bookingAgent;
	@OneToOne
	@JoinColumn(name = "account_id")
	private Customer				billTo;
	@OneToOne
	@JoinColumn(name = "consignee_id")
	private Customer				consignee;
	@OneToOne
	@JoinColumn(name = "local_ss_line_office_id")
	private Customer				localSSLineOffice;
	@OneToOne
	@JoinColumn(name = "notify1_id")
	private Customer				notify1;
	@OneToOne
	@JoinColumn(name = "notify2_id")
	private Customer				notify2;
	@OneToOne
	@JoinColumn(name = "shipper_id")
	private Customer				shipper;
	@OneToOne
	@JoinColumn(name = "cargo_supplier_id")
	private Customer				cargoSupplier;
	@OneToOne
	private User					user;
	@OneToOne
	@JoinColumn(name = "load_terminal_id")
	private Place					emptyContainerPickup;
	@OneToOne
	@JoinColumn(name = "ingate_terminal_id")
	private Place					ingateAtTerminal;
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

	public Place getIngateAtTerminal() {
		return ingateAtTerminal;
	}

	public void setIngateAtTerminal(Place ingateAtTerminal) {
		this.ingateAtTerminal = ingateAtTerminal;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getAmendmentDate() {
		return amendmentDate;
	}

	public void setAmendmentDate(LocalDateTime amendmentDate) {
		this.amendmentDate = amendmentDate;
	}

	public LocalDateTime getCargoMovingDate() {
		return cargoMovingDate;
	}

	public void setCargoMovingDate(LocalDateTime cargoMovingDate) {
		this.cargoMovingDate = cargoMovingDate;
	}

	public LocalDateTime getPortCutOffDate() {
		return portCutOffDate;
	}

	public void setPortCutOffDate(LocalDateTime portCutOffDate) {
		this.portCutOffDate = portCutOffDate;
	}

	public LocalDateTime getDelieveryEta() {
		return delieveryEta;
	}

	public void setDelieveryEta(LocalDateTime delieveryEta) {
		this.delieveryEta = delieveryEta;
	}

	public LocalDateTime getRailCutOffDateTime() {
		return railCutOffDateTime;
	}

	public void setRailCutOffDateTime(LocalDateTime railCutOffDateTime) {
		this.railCutOffDateTime = railCutOffDateTime;
	}

	public LocalDateTime getEta() {
		return eta;
	}

	public void setEta(LocalDateTime eta) {
		this.eta = eta;
	}

	public LocalDateTime getSailDate() {
		return sailDate;
	}

	public void setSailDate(LocalDateTime sailDate) {
		this.sailDate = sailDate;
	}

	public LocalDateTime getEmptyPickupDate() {
		return emptyPickupDate;
	}

	public void setEmptyPickupDate(LocalDateTime emptyPickupDate) {
		this.emptyPickupDate = emptyPickupDate;
	}

	public LocalDateTime getEarlyReceivingDate() {
		return earlyReceivingDate;
	}

	public void setEarlyReceivingDate(LocalDateTime earlyReceivingDate) {
		this.earlyReceivingDate = earlyReceivingDate;
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

	public Customer getCarrier() {
		return carrier;
	}

	public void setCarrier(Customer carrier) {
		this.carrier = carrier;
	}

	public Customer getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(Customer deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}

	public Customer getBookingAgent() {
		return bookingAgent;
	}

	public void setBookingAgent(Customer bookingAgent) {
		this.bookingAgent = bookingAgent;
	}

	public Customer getBillTo() {
		return billTo;
	}

	public void setBillTo(Customer billTo) {
		this.billTo = billTo;
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

	public Customer getNotify1() {
		return notify1;
	}

	public void setNotify1(Customer notify1) {
		this.notify1 = notify1;
	}

	public Customer getNotify2() {
		return notify2;
	}

	public void setNotify2(Customer notify2) {
		this.notify2 = notify2;
	}

	public Customer getShipper() {
		return shipper;
	}

	public void setShipper(Customer shipper) {
		this.shipper = shipper;
	}

	public Customer getCargoSupplier() {
		return cargoSupplier;
	}

	public void setCargoSupplier(Customer cargoSupplier) {
		this.cargoSupplier = cargoSupplier;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Place getEmptyContainerPickup() {
		return emptyContainerPickup;
	}

	public void setEmptyContainerPickup(Place emptyContainerPickup) {
		this.emptyContainerPickup = emptyContainerPickup;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forwarderRefNo == null) ? 0 : forwarderRefNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDetail other = (BookingDetail) obj;
		if (forwarderRefNo == null) {
			if (other.forwarderRefNo != null)
				return false;
		} else if (!forwarderRefNo.equals(other.forwarderRefNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
