package com.suis.logistics.repository.vessel;

import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Vessel> getVesselsByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Vessel.findByName").setParameter("name", name + "%");
		List<Vessel> vesselList = query.list();
		return vesselList;
	}
}
