package com.suis.logistics.web.cargo;

import com.suis.logistics.web.cargotemplate.CargoTemplateDto;
import com.suis.logistics.web.commodity.CommodityDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.piecetype.PieceTypeDto;

public class CargoDto {

	private Integer				id;
	private Integer				cartoonHieght;
	private Integer				cartoonLength;
	private Integer				cartoonWidth;
	private Integer				cartoons;
	private String				contentsDescription;
	private String				grossCbm;
	private String				grossCft;
	private String				grossKgs;
	private String				grossLbs;
	private Integer				htsId;
	private String				netCbm;
	private String				netCft;
	private String				netKgs;
	private String				netLbs;
	private Integer				noOfPieces;
	private String				unit;
	private CargoTemplateDto	cargoTemplate;
	private CommodityDto		commodity;
	private ContainerDto		containerDetail;
	private PieceTypeDto		pieceType;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCartoonHieght() {
		return cartoonHieght;
	}
	public void setCartoonHieght(Integer cartoonHieght) {
		this.cartoonHieght = cartoonHieght;
	}
	public Integer getCartoonLength() {
		return cartoonLength;
	}
	public void setCartoonLength(Integer cartoonLength) {
		this.cartoonLength = cartoonLength;
	}
	public Integer getCartoonWidth() {
		return cartoonWidth;
	}
	public void setCartoonWidth(Integer cartoonWidth) {
		this.cartoonWidth = cartoonWidth;
	}
	public Integer getCartoons() {
		return cartoons;
	}
	public void setCartoons(Integer cartoons) {
		this.cartoons = cartoons;
	}
	public String getContentsDescription() {
		return contentsDescription;
	}
	public void setContentsDescription(String contentsDescription) {
		this.contentsDescription = contentsDescription;
	}
	public String getGrossCbm() {
		return grossCbm;
	}
	public void setGrossCbm(String grossCbm) {
		this.grossCbm = grossCbm;
	}
	public String getGrossCft() {
		return grossCft;
	}
	public void setGrossCft(String grossCft) {
		this.grossCft = grossCft;
	}
	public String getGrossKgs() {
		return grossKgs;
	}
	public void setGrossKgs(String grossKgs) {
		this.grossKgs = grossKgs;
	}
	public String getGrossLbs() {
		return grossLbs;
	}
	public void setGrossLbs(String grossLbs) {
		this.grossLbs = grossLbs;
	}
	public Integer getHtsId() {
		return htsId;
	}
	public void setHtsId(Integer htsId) {
		this.htsId = htsId;
	}
	public String getNetCbm() {
		return netCbm;
	}
	public void setNetCbm(String netCbm) {
		this.netCbm = netCbm;
	}
	public String getNetCft() {
		return netCft;
	}
	public void setNetCft(String netCft) {
		this.netCft = netCft;
	}
	public String getNetKgs() {
		return netKgs;
	}
	public void setNetKgs(String netKgs) {
		this.netKgs = netKgs;
	}
	public String getNetLbs() {
		return netLbs;
	}
	public void setNetLbs(String netLbs) {
		this.netLbs = netLbs;
	}
	public Integer getNoOfPieces() {
		return noOfPieces;
	}
	public void setNoOfPieces(Integer noOfPieces) {
		this.noOfPieces = noOfPieces;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public CargoTemplateDto getCargoTemplate() {
		return cargoTemplate;
	}
	public void setCargoTemplate(CargoTemplateDto cargoTemplate) {
		this.cargoTemplate = cargoTemplate;
	}
	public CommodityDto getCommodity() {
		return commodity;
	}
	public void setCommodity(CommodityDto commodity) {
		this.commodity = commodity;
	}
	public ContainerDto getContainerDetail() {
		return containerDetail;
	}
	public void setContainerDetail(ContainerDto containerDetail) {
		this.containerDetail = containerDetail;
	}
	public PieceTypeDto getPieceType() {
		return pieceType;
	}
	public void setPieceType(PieceTypeDto pieceType) {
		this.pieceType = pieceType;
	}


}
