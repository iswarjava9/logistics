package com.suis.logistics.service.common;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.City;
import com.suis.logistics.model.TimeZone;


@Transactional
public interface RegionService {
	public List<City> getCitiesByName(String name);
	public List<TimeZone> getAvailableTimeZonesByCountry(String countryCode);


	//public void updateCitiesWithTimeZoneForCountryWithOnlyOneTimeZone();
	public void updateCityWithOneTimeZone_LeftOut();
	public void updateCityWithTimeZoneForCountryWithMultipleTimeZone(String countryCode);
}
