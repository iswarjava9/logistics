package com.suis.logistics.repository.cargo;

import com.suis.logistics.model.CargoTemplate;

public interface CargoTemplateDao {
	public Integer createCargoTemplate(CargoTemplate cargoTemplate);

	public CargoTemplate findById(int cargoTemplateId);
}
