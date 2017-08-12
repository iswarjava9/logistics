package com.suis.logistics.web.commodity;

import java.util.List;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.CargoTemplate;

public class CommodityDto {
	private int					id;
	private String				commodity;
	private String				description;
	private String				primaryQuantity;
	private String				scheduleB;
	private String				secondaryQuantity;
	private List<Cargo>			cargos;
	private List<CargoTemplate>	cargoTemplates;
}
