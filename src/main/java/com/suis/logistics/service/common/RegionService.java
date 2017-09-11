package com.suis.logistics.service.common;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.City;

@Transactional
public interface RegionService {
	public List<City> getCitiesByName(String name);
}
