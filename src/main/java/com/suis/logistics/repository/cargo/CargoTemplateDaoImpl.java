package com.suis.logistics.repository.cargo;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.CargoTemplate;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CargoTemplateDaoImpl extends BaseDao implements CargoTemplateDao {

	@Override
	public Integer createCargoTemplate(CargoTemplate cargoTemplate) {
		getCurrentSession().save(cargoTemplate);
		return cargoTemplate.getId();
	}

	@Override
	public CargoTemplate findById(int id) {
		return getCurrentSession().load(CargoTemplate.class, id);
	}
}
