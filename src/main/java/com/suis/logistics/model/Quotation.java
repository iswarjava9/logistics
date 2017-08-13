package com.suis.logistics.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the quotation database table.
 *
 */
@Entity
@Table(name="quotation")
@NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q")
public class Quotation implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	@Column(name = "agent_driven")
	private String				agentDriven;
	@Column(name = "container_handling")
	private String				containerHandling;
	@Column(name = "customer_ref_no")
	private String				customerRefNo;

	@Column(name = "effective_date")
	private ZonedDateTime				effectiveDate;

	@Column(name = "expiration_date")
	private ZonedDateTime		expirationDate;
	@Column(name = "inco_term_location")
	private String				incoTermLocation;
	@Column(name = "payment_term")
	private String				paymentTerm;
	@Column(name = "quote_no")
	private String				quoteNo;
	@Column(name = "quoted_by")
	private String				quotedBy;
	@Column(name = "transit_time")
	private String				transitTime;
	private String				voyage;
	// bi-directional many-to-one association to ContainerDetail
	@OneToOne(mappedBy = "quotation")
	private ContainerDetail		containerDetail;
	// bi-directional many-to-one association to BusinessLine
	@ManyToOne
	@JoinColumn(name = "business_line_id")
	private BusinessLine		businessLine;
	// bi-directional many-to-one association to Country
	@ManyToOne
	private Country				country;
	// bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer			customer;
	// bi-directional many-to-one association to Division
	@ManyToOne
	private Division			division;
	// bi-directional many-to-one association to IncoTerm
	@ManyToOne
	@JoinColumn(name = "inco_term_id")
	private IncoTerm			incoTerm;
	// bi-directional many-to-one association to MovementType
	@ManyToOne
	@JoinColumn(name = "type_of_movement_id")
	private MovementType		movementType;
	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Person				primaryContact;
	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "sales_representative_id")
	private Person				salesRepresentative;
	// bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name = "final_destination_id")
	private Place				finalDestination;
	// bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name = "pickup_city_id")
	private Place				pickupCity;
	// bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name = "port_of_discharge_id")
	private Place				portOfDischarge;
	// bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name = "port_of_load_id")
	private Place				portOfLoad;
	// bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name = "preferred_carrier_id")
	private Place				preferredCarrier;
	// bi-directional many-to-one association to ServiceLevel
	@ManyToOne
	@JoinColumn(name = "service_level_id")
	private ServiceLevel		serviceLevel;
	// bi-directional many-to-one association to ServiceType
	@ManyToOne
	@JoinColumn(name = "service_type_id")
	private ServiceType			serviceType;
	// bi-directional many-to-one association to State
	@ManyToOne
	private State				state;
	// bi-directional many-to-one association to Vessel
	@ManyToOne
	private Vessel				vessel;

	public Quotation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgentDriven() {
		return this.agentDriven;
	}

	public void setAgentDriven(String agentDriven) {
		this.agentDriven = agentDriven;
	}

	public String getContainerHandling() {
		return this.containerHandling;
	}

	public void setContainerHandling(String containerHandling) {
		this.containerHandling = containerHandling;
	}

	public String getCustomerRefNo() {
		return this.customerRefNo;
	}

	public void setCustomerRefNo(String customerRefNo) {
		this.customerRefNo = customerRefNo;
	}



	public ZonedDateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(ZonedDateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public ZonedDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(ZonedDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getIncoTermLocation() {
		return this.incoTermLocation;
	}

	public void setIncoTermLocation(String incoTermLocation) {
		this.incoTermLocation = incoTermLocation;
	}

	public String getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getQuoteNo() {
		return this.quoteNo;
	}

	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}

	public String getQuotedBy() {
		return this.quotedBy;
	}

	public void setQuotedBy(String quotedBy) {
		this.quotedBy = quotedBy;
	}

	public String getTransitTime() {
		return this.transitTime;
	}

	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}

	public String getVoyage() {
		return this.voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public ContainerDetail getContainerDetail() {
		return containerDetail;
	}

	public void setContainerDetail(ContainerDetail containerDetail) {
		this.containerDetail = containerDetail;
	}

	public BusinessLine getBusinessLine() {
		return this.businessLine;
	}

	public void setBusinessLine(BusinessLine businessLine) {
		this.businessLine = businessLine;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public IncoTerm getIncoTerm() {
		return this.incoTerm;
	}

	public void setIncoTerm(IncoTerm incoTerm) {
		this.incoTerm = incoTerm;
	}

	public MovementType getMovementType() {
		return this.movementType;
	}

	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}

	public Person getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Person primaryContact) {
		this.primaryContact = primaryContact;
	}

	public Person getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(Person salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public Place getFinalDestination() {
		return finalDestination;
	}

	public void setFinalDestination(Place finalDestination) {
		this.finalDestination = finalDestination;
	}

	public Place getPickupCity() {
		return pickupCity;
	}

	public void setPickupCity(Place pickupCity) {
		this.pickupCity = pickupCity;
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

	public Place getPreferredCarrier() {
		return preferredCarrier;
	}

	public void setPreferredCarrier(Place preferredCarrier) {
		this.preferredCarrier = preferredCarrier;
	}

	public ServiceLevel getServiceLevel() {
		return this.serviceLevel;
	}

	public void setServiceLevel(ServiceLevel serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public ServiceType getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Vessel getVessel() {
		return this.vessel;
	}

	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}
}
