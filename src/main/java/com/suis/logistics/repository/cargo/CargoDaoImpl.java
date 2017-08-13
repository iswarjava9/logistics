 package com.suis.logistics.repository.cargo;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CargoDaoImpl extends BaseDao implements CargoDao {

	@Override
	public Integer createCargo(Cargo cargo) {
		getCurrentSession().save(cargo);
		return cargo.getId();
	}

	@Override
	public Cargo findById(int id) {
		return getCurrentSession().load(Cargo.class, id);
	}
}
