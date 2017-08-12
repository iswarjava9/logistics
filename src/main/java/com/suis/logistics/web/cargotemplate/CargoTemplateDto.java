package com.suis.logistics.web.cargotemplate;

import java.util.List;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.Commodity;

public class CargoTemplateDto {
	private int			id;
	private String		cargoNo;
	private String		description;
	private int			htsId;
	private List<Cargo>	cargos;
	private Commodity	commodity;
}
