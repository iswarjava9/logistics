package com.suis.logistics.service.cargo;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.CargoTemplate;

@Transactional
public interface CargoService {

	public Integer createCargo(Cargo cargo);
	public Cargo getCargo(int id);
	public Integer createCargoTemplate(CargoTemplate cargoTemplate);
	public CargoTemplate getCargoTemplate(int id);
}
