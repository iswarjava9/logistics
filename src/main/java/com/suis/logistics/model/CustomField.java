package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.suis.logistics.service.invoice.CustomFieldsValue;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "custom_fields_mapping")
public class CustomField implements Serializable {

	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer				id;
	@Column(name = "zoho_custom_field_id")
	private String				customfield_id;
	private Boolean				is_active;
	private Boolean				show_in_all_pdf;
	@Transient
	private String				value_formatted;
	private String				data_type;
	private Integer				index;
	private String				label;
	private Boolean				show_on_pdf;
	private String				placeholder;
	@Transient
	private String				value;

	public String getCustomfield_id() {
		return customfield_id;
	}

	public void setCustomfield_id(String customfield_id) {
		this.customfield_id = customfield_id;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Boolean getShow_in_all_pdf() {
		return show_in_all_pdf;
	}

	public void setShow_in_all_pdf(Boolean show_in_all_pdf) {
		this.show_in_all_pdf = show_in_all_pdf;
	}

	public String getValue_formatted() {
		return value_formatted;
	}

	public void setValue_formatted(String value_formatted) {
		this.value_formatted = value_formatted;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getShow_on_pdf() {
		return show_on_pdf;
	}

	public void setShow_on_pdf(Boolean show_on_pdf) {
		this.show_on_pdf = show_on_pdf;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setValueFromBookingDetail(CustomFieldsValue value) {
		switch (this.index) {
			case 1:
				setValue(value.getHblValue());
				break;
			case 2:
				setValue(value.getShipperNameValue());
				break;
			case 3:
				setValue(value.getVesselVoyageValue());
				break;
			case 4:
				setValue(value.getContainerSealValue());
				break;
			case 5:
				setValue(value.getPortOfLoadingValue());
				break;
			case 6:
				setValue(value.getPortOfDischargeValue());
				break;
			case 7:
				setValue(value.getEtaValue());
				break;
			case 8:
				setValue(value.getCargoWeightValue());
				break;
			case 9:
				setValue(value.getShipmentDetailsValue());
				break;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
