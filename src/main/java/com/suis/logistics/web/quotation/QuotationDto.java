package com.suis.logistics.web.quotation;

import java.time.ZonedDateTime;

import com.suis.logistics.web.CountryDto;
import com.suis.logistics.web.StateDto;
import com.suis.logistics.web.businessline.BusinessLineDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.division.DivisionDto;
import com.suis.logistics.web.incoterm.IncoTermDto;
import com.suis.logistics.web.movementtype.MovementTypeDto;
import com.suis.logistics.web.person.PersonDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.servicelevel.ServiceLevelDto;
import com.suis.logistics.web.servicetype.ServiceTypeDto;
import com.suis.logistics.web.vessel.VesselDto;

public class QuotationDto {

	private Integer			id;
	private String			agentDriven;
	private String			containerHandling;
	private String			customerRefNo;
	private ZonedDateTime			effectiveDate;
	private ZonedDateTime	expirationDate;
	private String			incoTermLocation;
	private String			paymentTerm;
	private String			quoteNo;
	private String			quotedBy;
	private String			transitTime;
	private String			voyage;
	private ContainerDto	containerDetail;
	private BusinessLineDto	businessLine;
	private CountryDto		country;
	private CustomerDto		customer;
	private DivisionDto		division;
	private IncoTermDto		incoTerm;
	private MovementTypeDto	movementType;
	private PersonDto		primaryContact;
	private PersonDto		salesRepresentative;
	private PlaceDto		finalDestination;
	private PlaceDto		pickupCity;
	private PlaceDto		portOfDischarge;
	private PlaceDto		portOfLoad;
	private PlaceDto		preferredCarrier;
	private ServiceLevelDto	serviceLevel;
	private ServiceTypeDto	serviceType;
	private StateDto		state;
	private VesselDto		vessel;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAgentDriven() {
		return agentDriven;
	}
	public void setAgentDriven(String agentDriven) {
		this.agentDriven = agentDriven;
	}
	public String getContainerHandling() {
		return containerHandling;
	}
	public void setContainerHandling(String containerHandling) {
		this.containerHandling = containerHandling;
	}
	public String getCustomerRefNo() {
		return customerRefNo;
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
		return incoTermLocation;
	}
	public void setIncoTermLocation(String incoTermLocation) {
		this.incoTermLocation = incoTermLocation;
	}
	public String getPaymentTerm() {
		return paymentTerm;
	}
	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
	public String getQuoteNo() {
		return quoteNo;
	}
	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}
	public String getQuotedBy() {
		return quotedBy;
	}
	public void setQuotedBy(String quotedBy) {
		this.quotedBy = quotedBy;
	}
	public String getTransitTime() {
		return transitTime;
	}
	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public ContainerDto getContainerDetail() {
		return containerDetail;
	}
	public void setContainerDetail(ContainerDto containerDetail) {
		this.containerDetail = containerDetail;
	}
	public BusinessLineDto getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(BusinessLineDto businessLine) {
		this.businessLine = businessLine;
	}
	public CountryDto getCountry() {
		return country;
	}
	public void setCountry(CountryDto country) {
		this.country = country;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public DivisionDto getDivision() {
		return division;
	}
	public void setDivision(DivisionDto division) {
		this.division = division;
	}
	public IncoTermDto getIncoTerm() {
		return incoTerm;
	}
	public void setIncoTerm(IncoTermDto incoTerm) {
		this.incoTerm = incoTerm;
	}
	public MovementTypeDto getMovementType() {
		return movementType;
	}
	public void setMovementType(MovementTypeDto movementType) {
		this.movementType = movementType;
	}
	public PersonDto getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(PersonDto primaryContact) {
		this.primaryContact = primaryContact;
	}
	public PersonDto getSalesRepresentative() {
		return salesRepresentative;
	}
	public void setSalesRepresentative(PersonDto salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}
	public PlaceDto getFinalDestination() {
		return finalDestination;
	}
	public void setFinalDestination(PlaceDto finalDestination) {
		this.finalDestination = finalDestination;
	}
	public PlaceDto getPickupCity() {
		return pickupCity;
	}
	public void setPickupCity(PlaceDto pickupCity) {
		this.pickupCity = pickupCity;
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
	public PlaceDto getPreferredCarrier() {
		return preferredCarrier;
	}
	public void setPreferredCarrier(PlaceDto preferredCarrier) {
		this.preferredCarrier = preferredCarrier;
	}
	public ServiceLevelDto getServiceLevel() {
		return serviceLevel;
	}
	public void setServiceLevel(ServiceLevelDto serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	public ServiceTypeDto getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceTypeDto serviceType) {
		this.serviceType = serviceType;
	}
	public StateDto getState() {
		return state;
	}
	public void setState(StateDto state) {
		this.state = state;
	}
	public VesselDto getVessel() {
		return vessel;
	}
	public void setVessel(VesselDto vessel) {
		this.vessel = vessel;
	}


}
