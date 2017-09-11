package com.suis.logistics.repository.common;

import java.util.List;

import com.suis.logistics.model.City;

public interface RegionDao {

	public List<City> getCitiesByName(String name);
}
