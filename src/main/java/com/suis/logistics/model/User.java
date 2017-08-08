package com.suis.logistics.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	
	@Column(name = "email_id")
	private String				emailId;
	
	private String				name;
	
	private String				password;
	
	private String				role;
	
	private String				staus;
	
	@Column(name = "user_name")
	private String				userName;
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	private Client				client;
	
	// bi-directional many-to-one association to BookingDetail
	@OneToMany(mappedBy = "user")
	private List<BookingDetail>	bookingDetails;
	
	public User() {
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return this.emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getStaus() {
		return this.staus;
	}
	
	public void setStaus(String staus) {
		this.staus = staus;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<BookingDetail> getBookingDetails() {
		return this.bookingDetails;
	}
	
	public void setBookingDetails(List<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	
	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().add(bookingDetail);
		bookingDetail.setUser(this);
		
		return bookingDetail;
	}
	
	public BookingDetail removeBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().remove(bookingDetail);
		bookingDetail.setUser(null);
		
		return bookingDetail;
	}
	
}