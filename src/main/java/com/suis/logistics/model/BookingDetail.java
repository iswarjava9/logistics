package com.suis.logistics.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the booking_detail database table.
 *
 */
@Entity
@Table(name="booking_detail")
@NamedQuery(name="BookingDetail.findAll", query="SELECT b FROM BookingDetail b")
public class BookingDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="aes_auth_no")
	private String aesAuthNo;

	@Temporal(TemporalType.DATE)
	@Column(name="booking_date")
	private Date bookingDate;

	@Column(name="booking_person_id")
	private int bookingPersonId;

	@Column(name="booking_status_id")
	private int bookingStatusId;

	@Temporal(TemporalType.DATE)
	@Column(name="cargo_moving_date")
	private Date cargoMovingDate;

	@Column(name="carrier_booking_no")
	private String carrierBookingNo;

	@Column(name="carrier_contact")
	private String carrierContact;

	@Column(name="carrier_id")
	private int carrierId;

	@Column(name="carrier_voyage")
	private String carrierVoyage;

	private String controller;

	@Temporal(TemporalType.DATE)
	@Column(name="cut_off_date")
	private Date cutOffDate;

	@Temporal(TemporalType.DATE)
	@Column(name="delievery_eta")
	private Date delieveryEta;

	@Column(name="division_id")
	private int divisionId;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="docs_cut_off_date_time")
	private LocalDateTime docsCutOffDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="docs_received_date")
	private Date docsReceivedDate;

	@Temporal(TemporalType.DATE)
	private Date eta;

	@Column(name="forwarder_id")
	private int forwarderId;

	@Column(name="forwarder_ref_no")
	private String forwarderRefNo;

	private String freight;

	@Column(name="line_of_business_id")
	private int lineOfBusinessId;

	@Column(name="nra_number")
	private String nraNumber;

	@Column(name="nvocc_booking_no")
	private String nvoccBookingNo;

	@Temporal(TemporalType.DATE)
	@Column(name="rate_cut_off_date_time")
	private Date rateCutOffDateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="sail_date")
	private Date sailDate;

	@Column(name="sales_representative_id")
	private int salesRepresentativeId;

	@Column(name="service_contract_id")
	private int serviceContractId;

	@Column(name="shipper_ref_no")
	private String shipperRefNo;

	@Column(name="type_of_move_id")
	private int typeOfMoveId;

	@Column(name="type_of_service_id")
	private int typeOfServiceId;

	@Column(name="vessel_id")
	private int vesselId;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="foreign_agent_id")
	private Customer foreignAgent;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="account_id")
	private Customer account;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="consignee_id")
	private Customer consignee;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="local_ss_line_office_id")
	private Customer localSSLineOffice;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="notify_id")
	private Customer notify;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="shipper_id")
	private Customer shipper;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to PhysicalEntity
	@ManyToOne
	@JoinColumn(name="load_terminal_id")
	private Place loadTerminal;

	//bi-directional many-to-one association to PhysicalEntity
	@ManyToOne
	@JoinColumn(name="place_of_delivery_id")
	private Place placeOfDelivery;

	//bi-directional many-to-one association to PhysicalEntity
	@ManyToOne
	@JoinColumn(name="place_of_receipt_id")
	private Place placeOfReceipt;

	//bi-directional many-to-one association to PhysicalEntity
	@ManyToOne
	@JoinColumn(name="port_of_discharge_id")
	private Place portOfDischarge;

	//bi-directional many-to-one association to PhysicalEntity
	@ManyToOne
	@JoinColumn(name="port_of_load_id")
	private Place portOfLoad;

	//bi-directional many-to-one association to PhysicalEntity
	@ManyToOne
	@JoinColumn(name="transhipment_port_id")
	private Place transhipmentPort;

	public BookingDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAesAuthNo() {
		return this.aesAuthNo;
	}

	public void setAesAuthNo(String aesAuthNo) {
		this.aesAuthNo = aesAuthNo;
	}

	public Date getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getBookingPersonId() {
		return this.bookingPersonId;
	}

	public void setBookingPersonId(int bookingPersonId) {
		this.bookingPersonId = bookingPersonId;
	}

	public int getBookingStatusId() {
		return this.bookingStatusId;
	}

	public void setBookingStatusId(int bookingStatusId) {
		this.bookingStatusId = bookingStatusId;
	}

	public Date getCargoMovingDate() {
		return this.cargoMovingDate;
	}

	public void setCargoMovingDate(Date cargoMovingDate) {
		this.cargoMovingDate = cargoMovingDate;
	}

	public String getCarrierBookingNo() {
		return this.carrierBookingNo;
	}

	public void setCarrierBookingNo(String carrierBookingNo) {
		this.carrierBookingNo = carrierBookingNo;
	}

	public String getCarrierContact() {
		return this.carrierContact;
	}

	public void setCarrierContact(String carrierContact) {
		this.carrierContact = carrierContact;
	}

	public int getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierVoyage() {
		return this.carrierVoyage;
	}

	public void setCarrierVoyage(String carrierVoyage) {
		this.carrierVoyage = carrierVoyage;
	}

	public String getController() {
		return this.controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public Date getCutOffDate() {
		return this.cutOffDate;
	}

	public void setCutOffDate(Date cutOffDate) {
		this.cutOffDate = cutOffDate;
	}

	public Date getDelieveryEta() {
		return this.delieveryEta;
	}

	public void setDelieveryEta(Date delieveryEta) {
		this.delieveryEta = delieveryEta;
	}

	public int getDivisionId() {
		return this.divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public LocalDateTime getDocsCutOffDateTime() {
		return this.docsCutOffDateTime;
	}

	public void setDocsCutOffDateTime(LocalDateTime docsCutOffDateTime) {
		this.docsCutOffDateTime = docsCutOffDateTime;
	}

	public Date getDocsReceivedDate() {
		return this.docsReceivedDate;
	}

	public void setDocsReceivedDate(Date docsReceivedDate) {
		this.docsReceivedDate = docsReceivedDate;
	}

	public Date getEta() {
		return this.eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public int getForwarderId() {
		return this.forwarderId;
	}

	public void setForwarderId(int forwarderId) {
		this.forwarderId = forwarderId;
	}

	public String getForwarderRefNo() {
		return this.forwarderRefNo;
	}

	public void setForwarderRefNo(String forwarderRefNo) {
		this.forwarderRefNo = forwarderRefNo;
	}

	public String getFreight() {
		return this.freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public int getLineOfBusinessId() {
		return this.lineOfBusinessId;
	}

	public void setLineOfBusinessId(int lineOfBusinessId) {
		this.lineOfBusinessId = lineOfBusinessId;
	}

	public String getNraNumber() {
		return this.nraNumber;
	}

	public void setNraNumber(String nraNumber) {
		this.nraNumber = nraNumber;
	}

	public String getNvoccBookingNo() {
		return this.nvoccBookingNo;
	}

	public void setNvoccBookingNo(String nvoccBookingNo) {
		this.nvoccBookingNo = nvoccBookingNo;
	}

	public Date getRateCutOffDateTime() {
		return this.rateCutOffDateTime;
	}

	public void setRateCutOffDateTime(Date rateCutOffDateTime) {
		this.rateCutOffDateTime = rateCutOffDateTime;
	}

	public Date getSailDate() {
		return this.sailDate;
	}

	public void setSailDate(Date sailDate) {
		this.sailDate = sailDate;
	}

	public int getSalesRepresentativeId() {
		return this.salesRepresentativeId;
	}

	public void setSalesRepresentativeId(int salesRepresentativeId) {
		this.salesRepresentativeId = salesRepresentativeId;
	}

	public int getServiceContractId() {
		return this.serviceContractId;
	}

	public void setServiceContractId(int serviceContractId) {
		this.serviceContractId = serviceContractId;
	}

	public String getShipperRefNo() {
		return this.shipperRefNo;
	}

	public void setShipperRefNo(String shipperRefNo) {
		this.shipperRefNo = shipperRefNo;
	}

	public int getTypeOfMoveId() {
		return this.typeOfMoveId;
	}

	public void setTypeOfMoveId(int typeOfMoveId) {
		this.typeOfMoveId = typeOfMoveId;
	}

	public int getTypeOfServiceId() {
		return this.typeOfServiceId;
	}

	public void setTypeOfServiceId(int typeOfServiceId) {
		this.typeOfServiceId = typeOfServiceId;
	}

	public int getVesselId() {
		return this.vesselId;
	}

	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		return this.user;
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

	@Override
	public String toString() {
		return "BookingDetail [id=" + id + ", aesAuthNo=" + aesAuthNo + ", bookingDate=" + bookingDate
				+ ", bookingPersonId=" + bookingPersonId + ", bookingStatusId=" + bookingStatusId + ", cargoMovingDate="
				+ cargoMovingDate + ", carrierBookingNo=" + carrierBookingNo + ", carrierContact=" + carrierContact
				+ ", carrierId=" + carrierId + ", carrierVoyage=" + carrierVoyage + ", controller=" + controller
				+ ", cutOffDate=" + cutOffDate + ", delieveryEta=" + delieveryEta + ", divisionId=" + divisionId
				+ ", docsCutOffDateTime=" + docsCutOffDateTime + ", docsReceivedDate=" + docsReceivedDate + ", eta="
				+ eta + ", forwarderId=" + forwarderId + ", forwarderRefNo=" + forwarderRefNo + ", freight=" + freight
				+ ", lineOfBusinessId=" + lineOfBusinessId + ", nraNumber=" + nraNumber + ", nvoccBookingNo="
				+ nvoccBookingNo + ", rateCutOffDateTime=" + rateCutOffDateTime + ", sailDate=" + sailDate
				+ ", salesRepresentativeId=" + salesRepresentativeId + ", serviceContractId=" + serviceContractId
				+ ", shipperRefNo=" + shipperRefNo + ", typeOfMoveId=" + typeOfMoveId + ", typeOfServiceId="
				+ typeOfServiceId + ", vesselId=" + vesselId + ", client=" + client + ", foreignAgent=" + foreignAgent
				+ ", account=" + account + ", consignee=" + consignee + ", localSSLineOffice=" + localSSLineOffice
				+ ", notify=" + notify + ", shipper=" + shipper + ", user=" + user + ", loadTerminal=" + loadTerminal
				+ ", placeOfDelivery=" + placeOfDelivery + ", placeOfReceipt=" + placeOfReceipt + ", portOfDischarge="
				+ portOfDischarge + ", portOfLoad=" + portOfLoad + ", transhipmentPort=" + transhipmentPort + "]";
	}



}