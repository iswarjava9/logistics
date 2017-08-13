package com.suis.logistics.repository.vessel;

import com.suis.logistics.model.Vessel;

public interface VesselDao {
	public Integer createVessel(Vessel vessel);

	public Vessel findById(int id);
}
