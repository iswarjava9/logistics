package com.suis.logistics.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the container_type database table.
 *
 */
@Entity
@Table(name="container_type")
@NamedQuery(name="ContainerType.findAll", query="SELECT c FROM ContainerType c")
public class ContainerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double cbm;

	@Column(name="container_type")
	private String containerType;

	private String descirption;

	@Column(name="iso_code")
	private String isoCode;

	private String size;

	private double teu;

	private String type;

	//bi-directional many-to-one association to ContainerDetail
	@OneToMany(mappedBy="containerType")
	private List<ContainerDetail> containerDetails;

	public ContainerType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCbm() {
		return this.cbm;
	}

	public void setCbm(double cbm) {
		this.cbm = cbm;
	}

	public String getContainerType() {
		return this.containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getDescirption() {
		return this.descirption;
	}

	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}

	public String getIsoCode() {
		return this.isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getTeu() {
		return this.teu;
	}

	public void setTeu(double teu) {
		this.teu = teu;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ContainerDetail> getContainerDetails() {
		return this.containerDetails;
	}

	public void setContainerDetails(List<ContainerDetail> containerDetails) {
		this.containerDetails = containerDetails;
	}

	public ContainerDetail addContainerDetail(ContainerDetail containerDetail) {
		getContainerDetails().add(containerDetail);
		containerDetail.setContainerType(this);

		return containerDetail;
	}

	public ContainerDetail removeContainerDetail(ContainerDetail containerDetail) {
		getContainerDetails().remove(containerDetail);
		containerDetail.setContainerType(null);

		return containerDetail;
	}

}