package com.suis.logistics.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the division database table.
 * 
 */
@Entity
@Table(name = "division")
@NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d")
public class Division implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int					id;
	
	@Column(name = "branch_address")
	private String				branchAddress;
	
	private String				code;
	
	private String				name;
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	private Client				client;
	
	public Division() {
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBranchAddress() {
		return this.branchAddress;
	}
	
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
}