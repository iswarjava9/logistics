package com.suis.logistics.web.container;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.suis.logistics.web.cargo.CargoDto;
import com.suis.logistics.web.commodity.CommodityDto;
import com.suis.logistics.web.containertype.ContainerTypeDto;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		pickupLocalDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		plannedShipLocalDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		cusPickupLastFreeLocalDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		cusReturnLastFreeLocalDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		carrierPickupLastFreeLocalDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		carrierReturnLastFreeLocalDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime		dischargeLocalDateTime;

	private List<CargoDto>		cargos;
	private Integer				bookingId;
	private ContainerTypeDto	containerType;
	private CommodityDto		commodity;
	private Integer				quotationId;

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

	public ContainerTypeDto getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerTypeDto containerType) {
		this.containerType = containerType;
	}

	public CommodityDto getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityDto commodity) {
		this.commodity = commodity;
	}

	public Integer getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}

	public Integer getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(Integer vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Integer getStuffingNo() {
		return stuffingNo;
	}

	public void setStuffingNo(Integer stuffingNo) {
		this.stuffingNo = stuffingNo;
	}

	public Integer getRailwayBillNo() {
		return railwayBillNo;
	}

	public void setRailwayBillNo(Integer railwayBillNo) {
		this.railwayBillNo = railwayBillNo;
	}

	public LocalDateTime getPickupLocalDateTime() {
		return pickupLocalDateTime;
	}

	public void setPickupLocalDateTime(LocalDateTime pickupLocalDateTime) {
		this.pickupLocalDateTime = pickupLocalDateTime;
	}

	public LocalDateTime getPlannedShipLocalDateTime() {
		return plannedShipLocalDateTime;
	}

	public void setPlannedShipLocalDateTime(LocalDateTime plannedShipLocalDateTime) {
		this.plannedShipLocalDateTime = plannedShipLocalDateTime;
	}

	public LocalDateTime getCusPickupLastFreeLocalDateTime() {
		return cusPickupLastFreeLocalDateTime;
	}

	public void setCusPickupLastFreeLocalDateTime(LocalDateTime cusPickupLastFreeLocalDateTime) {
		this.cusPickupLastFreeLocalDateTime = cusPickupLastFreeLocalDateTime;
	}

	public LocalDateTime getCusReturnLastFreeLocalDateTime() {
		return cusReturnLastFreeLocalDateTime;
	}

	public void setCusReturnLastFreeLocalDateTime(LocalDateTime cusReturnLastFreeLocalDateTime) {
		this.cusReturnLastFreeLocalDateTime = cusReturnLastFreeLocalDateTime;
	}



	public LocalDateTime getCarrierPickupLastFreeLocalDateTime() {
		return carrierPickupLastFreeLocalDateTime;
	}

	public void setCarrierPickupLastFreeLocalDateTime(LocalDateTime carrierPickupLastFreeLocalDateTime) {
		this.carrierPickupLastFreeLocalDateTime = carrierPickupLastFreeLocalDateTime;
	}

	public LocalDateTime getCarrierReturnLastFreeLocalDateTime() {
		return carrierReturnLastFreeLocalDateTime;
	}

	public void setCarrierReturnLastFreeLocalDateTime(LocalDateTime carrierReturnLastFreeLocalDateTime) {
		this.carrierReturnLastFreeLocalDateTime = carrierReturnLastFreeLocalDateTime;
	}

	public LocalDateTime getDischargeLocalDateTime() {
		return dischargeLocalDateTime;
	}

	public void setDischargeLocalDateTime(LocalDateTime dischargeLocalDateTime) {
		this.dischargeLocalDateTime = dischargeLocalDateTime;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}



}
