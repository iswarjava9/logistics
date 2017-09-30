package com.suis.logistics.service.common;

import java.util.List;

import com.suis.logistics.model.City;
import com.suis.logistics.model.TimeZone;


public interface RegionService {
	public List<City> getCitiesByName(String name);
	public List<TimeZone> getAvailableTimeZonesByCountry(String countryCode);


	//public void updateCitiesWithTimeZoneForCountryWithOnlyOneTimeZone();
	public void updateCityWithOneTimeZone_LeftOut();
	public void updateCityWithTimeZoneForCountryWithMultipleTimeZone(String countryCode);
}
