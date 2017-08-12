package com.suis.logistics.web.containertype;

import java.util.List;

import com.suis.logistics.model.ContainerDetail;

public class ContainerTypeDto {
	private int						id;
	private double					cbm;
	private String					containerType;
	private String					descirption;
	private String					isoCode;
	private String					size;
	private double					teu;
	private String					type;
	private List<ContainerDetail>	containerDetails;
}
