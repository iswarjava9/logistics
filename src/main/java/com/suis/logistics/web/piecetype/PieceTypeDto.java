package com.suis.logistics.web.piecetype;

public class PieceTypeDto {
	private Integer		id;
	private boolean	bulkItem;
	private String	ediCode1;
	private String	ediCode2;
	private boolean	handheldScanner;
	private boolean	inactive;
	private String	pieceType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isBulkItem() {
		return bulkItem;
	}
	public void setBulkItem(boolean bulkItem) {
		this.bulkItem = bulkItem;
	}
	public String getEdiCode1() {
		return ediCode1;
	}
	public void setEdiCode1(String ediCode1) {
		this.ediCode1 = ediCode1;
	}
	public String getEdiCode2() {
		return ediCode2;
	}
	public void setEdiCode2(String ediCode2) {
		this.ediCode2 = ediCode2;
	}
	public boolean isHandheldScanner() {
		return handheldScanner;
	}
	public void setHandheldScanner(boolean handheldScanner) {
		this.handheldScanner = handheldScanner;
	}
	public boolean isInactive() {
		return inactive;
	}
	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	public String getPieceType() {
		return pieceType;
	}
	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}


}
