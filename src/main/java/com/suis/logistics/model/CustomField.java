package com.suis.logistics.model;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

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
import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.container.ContainerDto;

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

	public void setValueFromBookingDetail(BookingDto bookingDto) {
		switch (this.index) {
			case 1:
				setValue(bookingDto.getForwarderRefNo()); // TODO for HBL#
				break;
			case 2:
				setValue(bookingDto.getShipper().getName());
				break;
			case 3:
				setValue(bookingDto.getVessel().getName() + " / " + bookingDto.getCarrierVoyage());
				break;
			case 4:
				setValue(getContainerDetails(bookingDto));
				break;
			case 5:
				setValue(bookingDto.getPortOfLoad().getName());
				break;
			case 6:
				setValue(bookingDto.getPortOfDischarge() != null ? bookingDto.getPortOfDischarge().getName()
						: "NA" + " / " + bookingDto.getPlaceOfDelivery() != null
								? bookingDto.getPlaceOfDelivery().getName() : "NA");
				break;
			case 7:
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String formatDateTime = bookingDto.getEta().format(formatter);
				setValue(formatDateTime);
				break;
			case 8:
				setValue("NA"); // TODO for Cargo Weight
				break;
			case 9:
				setValue(getCommodityDetails(bookingDto));
		}
	}

	private String getContainerDetails(BookingDto bookingDto) {
		StringBuilder containersText = new StringBuilder("");
		int count = 1;
		for (ContainerDto containerDto : bookingDto.getContainerDetails()) {
			if (count != 1) {
				containersText.append(",");
			}
			containersText.append(containerDto.getContainerNo()).append(" / ").append(containerDto.getSeal1());
		}
		return containersText.toString();
	}

	private String getCommodityDetails(BookingDto bookingDto) {
		StringBuilder commodityText = new StringBuilder("");
		int count = 1;
		for (ContainerDto containerDto : bookingDto.getContainerDetails()) {
			if (count != 1) {
				commodityText.append(",");
			}
			commodityText.append(containerDto.getCommodity().getName());
		}
		return commodityText.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
