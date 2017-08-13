package com.suis.logistics.service.cargo;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.CargoTemplate;
import com.suis.logistics.repository.cargo.CargoDao;
import com.suis.logistics.repository.cargo.CargoTemplateDao;

@Component
public class CargoServiceImpl implements CargoService {
	@Resource
	CargoDao			cargoDao;
	@Resource
	CargoTemplateDao	cargoTemplateDao;

	@Override
	public Integer createCargo(Cargo cargo) {
		cargoDao.createCargo(cargo);
		return cargo.getId();
	}

	@Override
	public Cargo getCargo(int id) {
		return cargoDao.findById(id);
	}

	@Override
	public Integer createCargoTemplate(CargoTemplate cargoTemplate) {
		return cargoTemplateDao.createCargoTemplate(cargoTemplate);
	}

	@Override
	public CargoTemplate getCargoTemplate(int id) {
		return cargoTemplateDao.findById(id);
	}
}
