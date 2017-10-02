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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the customer database table.
 *
 */
@Entity
@Table(name = "customer")
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
		@NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c where c.name like :name") })
public class Customer implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	private String				address;
	@Column(name = "personincharge")
	private String				personInCharge;
	@OneToOne
	@JoinColumn(name = "city_id")
	private City				city;
	@Column(name = "zip_code")
	private String				zipCode;
	// bi-directional many-to-one association to Client
	@ManyToOne
	private Client				client;
	@Column(name = "email_id")
	private String				emailId;
	@Column(name = "phone_no")
	private String				phoneNo;
	@Column(name = "tax_id")
	private String				taxId;
	// bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy = "customer")
	private List<Quotation>		quotations;
	@Column(name = "tp_customer_id")
	private String				tpCustomerId;
	private String				name;

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public List<Quotation> getQuotations() {
		return quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public String getTpCustomerId() {
		return tpCustomerId;
	}

	public void setTpCustomerId(String tpCustomerId) {
		this.tpCustomerId = tpCustomerId;
	}
}
