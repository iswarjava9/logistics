package com.suis.logistics.web.container;

import java.util.Date;
import java.util.List;

import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.cargo.CargoDto;
import com.suis.logistics.web.containertype.ContainerTypeDto;
import com.suis.logistics.web.quotation.QuotationDto;

public class ContainerDto {
	private Integer				id;
	private String				containerNo;
	private String				equipment;
	private Double				grossKgs;
	private Double				grossLbs;
	private String				seal1;
	private String				seal2;
	private String				seal3;
	private Double				tareKgs;
	private Double				tareLbs;
	private Integer				vehicleNo;
	private Integer				stuffingNo;
	private Integer				railwayBillNo;
	private Date				pickupDate;
	private Date				plannedShipDate;
	private Date				cusPickupLastFreeDate;
	private Date				cusReturnLastFreeDate;
	private Date				carPickupLastFreeDate;
	private Date				carReturnLastFreeDate;
	private Date				dischargeDate;
	private List<CargoDto>		cargos;
	private BookingDto			bookingDetail;
	private ContainerTypeDto	containerType;
	private QuotationDto		quotation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public Double getGrossKgs() {
		return grossKgs;
	}

	public void setGrossKgs(Double grossKgs) {
		this.grossKgs = grossKgs;
	}

	public Double getGrossLbs() {
		return grossLbs;
	}

	public void setGrossLbs(Double grossLbs) {
		this.grossLbs = grossLbs;
	}

	public String getSeal1() {
		return seal1;
	}

	public void setSeal1(String seal1) {
		this.seal1 = seal1;
	}

	public String getSeal2() {
		return seal2;
	}

	public void setSeal2(String seal2) {
		this.seal2 = seal2;
	}

	public String getSeal3() {
		return seal3;
	}

	public void setSeal3(String seal3) {
		this.seal3 = seal3;
	}

	public Double getTareKgs() {
		return tareKgs;
	}

	public void setTareKgs(Double tareKgs) {
		this.tareKgs = tareKgs;
	}

	public Double getTareLbs() {
		return tareLbs;
	}

	public void setTareLbs(Double tareLbs) {
		this.tareLbs = tareLbs;
	}

	public List<CargoDto> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoDto> cargos) {
		this.cargos = cargos;
	}

	public BookingDto getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(BookingDto bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public ContainerTypeDto getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerTypeDto containerType) {
		this.containerType = containerType;
	}

	public QuotationDto getQuotation() {
		return quotation;
	}

	public void setQuotation(QuotationDto quotation) {
		this.quotation = quotation;
	}
}
