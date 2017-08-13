package com.suis.logistics.web.movementtype;

public class MovementTypeDto {

	private Integer	id;
	private String	description;
	private String	ediCode;
	private String	movesEnd;
	private String	movesStart;
	private String	typeOfService;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdiCode() {
		return ediCode;
	}

	public void setEdiCode(String ediCode) {
		this.ediCode = ediCode;
	}

	public String getMovesEnd() {
		return movesEnd;
	}

	public void setMovesEnd(String movesEnd) {
		this.movesEnd = movesEnd;
	}

	public String getMovesStart() {
		return movesStart;
	}

	public void setMovesStart(String movesStart) {
		this.movesStart = movesStart;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}
}
