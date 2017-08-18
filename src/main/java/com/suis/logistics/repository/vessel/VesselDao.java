package com.suis.logistics.repository.vessel;

import java.util.List;

import com.suis.logistics.model.Vessel;

public interface VesselDao {
	public Integer createVessel(Vessel vessel);

	public Vessel findById(int id);

	public List<Vessel> getAllVessels();
}
