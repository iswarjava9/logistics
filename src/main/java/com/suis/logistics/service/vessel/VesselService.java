package com.suis.logistics.service.vessel;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Vessel;

@Transactional
public interface VesselService {

	public Integer createVessel(Vessel vessel);
	public Vessel getVessel(int id);
	public List<Vessel> getAllVessels();
}
