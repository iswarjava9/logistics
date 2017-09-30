package com.suis.logistics.repository.common;

import java.util.List;

import com.suis.logistics.model.City;
import com.suis.logistics.model.TimeZone;


public interface RegionDao {

	public List<City> getCitiesByName(String name);
	public List<City> getAllCitiesWithTimeZoneNull();
	public City getCityForCountryCodeWithTimeZoneAvailable(String countryCode);
	public void updateCity(City city);
	public List<TimeZone> findAvailableTimeZonesByCountry(String countryCode);
	public List<TimeZone> getAllTimeZones();
}
