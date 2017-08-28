package com.suis.logistics.model;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 * The persistent class for the customer database table.
 *
 */
@Entity
@Table(name = "customer")
@NamedQueries({@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
	@NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c where c.name like :name")})

public class Customer implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	private String				address;
	@Column(name = "ams2_ops_controller")
	private String				ams2OpsController;
	private String				city;
	@Column(name = "country_code")
	private String				countryCode;
	@Column(name = "industry_id")
	private int					industryId;
	private String				name;
	@Column(name = "state_code")
	private String				stateCode;
	private String				street;
	private String				type;
	@Column(name = "zip_code")
	private String				zipCode;
	// bi-directional many-to-one association to Client
	@ManyToOne
	private Client				client;
	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Person				primaryContact;

	// bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy = "customer")
	private List<Quotation>		quotations;

	public Customer() {
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getAms2OpsController() {

		return ams2OpsController;
	}

	public void setAms2OpsController(String ams2OpsController) {

		this.ams2OpsController = ams2OpsController;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public String getCountryCode() {

		return countryCode;
	}

	public void setCountryCode(String countryCode) {

		this.countryCode = countryCode;
	}

	public int getIndustryId() {

		return industryId;
	}

	public void setIndustryId(int industryId) {

		this.industryId = industryId;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getStateCode() {

		return stateCode;
	}

	public void setStateCode(String stateCode) {

		this.stateCode = stateCode;
	}

	public String getStreet() {

		return street;
	}

	public void setStreet(String street) {

		this.street = street;
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getZipCode() {

		return zipCode;
	}

	public void setZipCode(String zipCode) {

		this.zipCode = zipCode;
	}

	public Client getClient() {

		return client;
	}

	public void setClient(Client client) {

		this.client = client;
	}

	public Person getPrimaryContact() {

		return primaryContact;
	}

	public void setPrimaryContact(Person primaryContact) {

		this.primaryContact = primaryContact;
	}

	public List<Quotation> getQuotations() {
		return quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}
}
