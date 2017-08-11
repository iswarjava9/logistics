package com.suis.logistics.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the quotation database table.
 *
 */
@Entity
@NamedQuery(name="Quotation.findAll", query="SELECT q FROM Quotation q")
public class Quotation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="agent_driven")
	private String agentDriven;

	@Column(name="container_handling")
	private String containerHandling;

	@Column(name="customer_ref_no")
	private String customerRefNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="effective_date")
	private Date effectiveDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiration_date")
	private Date expirationDate;

	@Column(name="inco_term_location")
	private String incoTermLocation;

	@Column(name="payment_term")
	private String paymentTerm;

	@Column(name="quote_no")
	private String quoteNo;

	@Column(name="quoted_by")
	private String quotedBy;

	@Column(name="transit_time")
	private String transitTime;

	private String voyage;

	//bi-directional many-to-one association to ContainerDetail
	@OneToMany(mappedBy="quotation")
	private List<ContainerDetail> containerDetails;

	//bi-directional many-to-one association to BusinessLine
	@ManyToOne
	@JoinColumn(name="business_line_id")
	private BusinessLine businessLine;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	//bi-directional many-to-one association to Division
	@ManyToOne
	private Division division;

	//bi-directional many-to-one association to IncoTerm
	@ManyToOne
	@JoinColumn(name="inco_term_id")
	private IncoTerm incoTerm;

	//bi-directional many-to-one association to MovementType
	@ManyToOne
	@JoinColumn(name="type_of_movement_id")
	private MovementType movementType;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="contact_id")
	private Person person1;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="sales_representative_id")
	private Person person2;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="final_destination_id")
	private Place place1;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="pickup_city_id")
	private Place place2;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="port_of_discharge_id")
	private Place place3;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="port_of_load_id")
	private Place place4;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="preferred_carrier_id")
	private Place place5;

	//bi-directional many-to-one association to ServiceLevel
	@ManyToOne
	@JoinColumn(name="service_level_id")
	private ServiceLevel serviceLevel;

	//bi-directional many-to-one association to ServiceType
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceType serviceType;

	//bi-directional many-to-one association to State
	@ManyToOne
	private State state;

	//bi-directional many-to-one association to Vessel
	@ManyToOne
	private Vessel vessel;

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

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
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

	public List<ContainerDetail> getContainerDetails() {
		return this.containerDetails;
	}

	public void setContainerDetails(List<ContainerDetail> containerDetails) {
		this.containerDetails = containerDetails;
	}

	public ContainerDetail addContainerDetail(ContainerDetail containerDetail) {
		getContainerDetails().add(containerDetail);
		containerDetail.setQuotation(this);

		return containerDetail;
	}

	public ContainerDetail removeContainerDetail(ContainerDetail containerDetail) {
		getContainerDetails().remove(containerDetail);
		containerDetail.setQuotation(null);

		return containerDetail;
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

	public Person getPerson1() {
		return this.person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return this.person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public Place getPlace1() {
		return this.place1;
	}

	public void setPlace1(Place place1) {
		this.place1 = place1;
	}

	public Place getPlace2() {
		return this.place2;
	}

	public void setPlace2(Place place2) {
		this.place2 = place2;
	}

	public Place getPlace3() {
		return this.place3;
	}

	public void setPlace3(Place place3) {
		this.place3 = place3;
	}

	public Place getPlace4() {
		return this.place4;
	}

	public void setPlace4(Place place4) {
		this.place4 = place4;
	}

	public Place getPlace5() {
		return this.place5;
	}

	public void setPlace5(Place place5) {
		this.place5 = place5;
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