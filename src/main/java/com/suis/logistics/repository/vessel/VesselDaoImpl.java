package com.suis.logistics.repository.vessel;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Vessel;
import com.suis.logistics.repository.BaseDao;

@Repository
public class VesselDaoImpl extends BaseDao implements VesselDao {

	@Override
	public Integer createVessel(Vessel vessel) {
		getCurrentSession().save(vessel);
		return vessel.getId();
	}

	@Override
	public Vessel findById(int id) {
		return getCurrentSession().load(Vessel.class, id);
	}
}
