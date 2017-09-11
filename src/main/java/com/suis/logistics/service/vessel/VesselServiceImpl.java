package com.suis.logistics.service.vessel;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Vessel;
import com.suis.logistics.repository.vessel.VesselDao;

@Component
public class VesselServiceImpl implements VesselService {
	@Resource
	VesselDao vesselDao;

	@Override
	public Integer createVessel(Vessel vessel) {
		return vesselDao.createVessel(vessel);
	}

	@Override
	public Vessel getVessel(int id) {
		return vesselDao.findById(id);
	}

	@Override
	public List<Vessel> getVesselsByName(String name) {
		return vesselDao.getVesselsByName(name);
	}
}
