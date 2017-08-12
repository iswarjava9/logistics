package com.suis.logistics.web.cargo;

import com.suis.logistics.model.CargoTemplate;
import com.suis.logistics.model.Commodity;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.PieceType;

public class CargoDto {

	private Integer				id;
	private Integer				cartoonHieght;
	private Integer				cartoonLength;
	private Integer				cartoonWidth;
	private Integer				cartoons;
	private String			contentsDescription;
	private String			grossCbm;
	private String			grossCft;
	private String			grossKgs;
	private String			grossLbs;
	private Integer				htsId;
	private String			netCbm;
	private String			netCft;
	private String			netKgs;
	private String			netLbs;
	private Integer				noOfPieces;
	private String			unit;
	private CargoTemplate	cargoTemplate;
	private Commodity		commodity;
	private ContainerDetail	containerDetail;
	private PieceType		pieceType;
}
