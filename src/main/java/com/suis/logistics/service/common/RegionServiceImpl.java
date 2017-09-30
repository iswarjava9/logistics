package com.suis.logistics.service.common;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.model.City;
import com.suis.logistics.model.TimeZone;
import com.suis.logistics.model.TimeZoneApiEntity;
import com.suis.logistics.model.TimeZoneApiResponse;
import com.suis.logistics.repository.common.RegionDao;

@Component
public class RegionServiceImpl implements RegionService {
	@Resource
	RegionDao regionDao;

	@Override
	public List<City> getCitiesByName(String name) {
		return regionDao.getCitiesByName(name);
	}

	@Override
	public List<TimeZone> getAvailableTimeZonesByCountry(String countryCode) {
		return regionDao.findAvailableTimeZonesByCountry(countryCode);
	}

	/*@Override
	public void updateCitiesWithTimeZoneForCountryWithOnlyOneTimeZone() {

		int count = 1;
		Map<City, String> failedCities = new HashMap<>();
		Map<String, TimeZoneApiEntity> countryTimeZoneMap = new HashMap<>();
		// while (firstResult <= totalRecords) {
		List<City> cities = regionDao.getAllCitiesWithTimeZoneNull();
		for (City city : cities) {
			try {

				if (countryTimeZoneMap.get(city.getState().getCountry().getCode()) == null) {
					TimeZoneApiResponse response = getTimeZones(city.getState().getCountry().getCode(), city.getName());
					if (!response.getStatus().equalsIgnoreCase("FAILED")) {
						countryTimeZoneMap.put(city.getState().getCountry().getCode(), response.getZones().get(0));
					}
				}
				for (String key : countryTimeZoneMap.keySet()) {
					if (city.getState().getCountry().getCode().equalsIgnoreCase(key)) {
						city.setTimeZoneId(countryTimeZoneMap.get(key).getZoneName());
						city.setTimeZoneAbbereviation(countryTimeZoneMap.get(key).getAbbreviation());
						regionDao.updateCity(city);
						count++;
					}
				}
				// ---------------------------------

				 * TimeZoneApiResponse response =
				 * getTimeZones(city.getState().getCountry().getCode(),
				 * city.getName()); if
				 * (!response.getStatus().equalsIgnoreCase("FAILED")) {
				 * List<TimeZoneApiEntity> zones = response.getZones(); if
				 * (zones != null && zones.size() > 1) { for (TimeZoneApiEntity
				 * zone : zones) { if
				 * (zone.getCountryCode().equals(city.getState().getCountry(
				 * ).getCode()) &&
				 * (zone.getRegionName().contains(city.getState().getName()) ||
				 * city.getState().getName().contains(zone.getRegionName())) ) {
				 * city.setTimeZoneId(zone.getZoneName());
				 * city.setTimeZoneAbbereviation(zone.getAbbreviation());
				 * regionDao.updateCity(city); count++; } } } else if (zones !=
				 * null && zones.size() == 1) {
				 * city.setTimeZoneId(zones.get(0).getZoneName());
				 * city.setTimeZoneAbbereviation(zones.get(0).
				 * getAbbreviation()); regionDao.updateCity(city); count++; } }
				 * else { failedCities.put(city,
				 * "No Record Found in timezone API \n"); }

			} catch (Exception e) {
				System.out
						.println("Failed updating City for city id :" + city.getId() + " and name : " + city.getName());
				e.printStackTrace();
				failedCities.put(city, e.getMessage() + "\n");
			}
		}



		System.out.println("Total no of records updated : " + count);
		System.out.println("Failed cities : " + failedCities);
	}

*/

	@Override
	public void updateCityWithTimeZoneForCountryWithMultipleTimeZone(String countryCode) {
		int count = 1;
		List<City> cities = regionDao.getAllCitiesWithTimeZoneNull();
       // System.out.println("Cities : "+ cities);
		Map<City, String> failedCities = new HashMap<>();
		for (City city : cities) {
			TimeZoneApiResponse response = null;
			try {
				response = getTimeZones(city.getCountryCode(), city.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!response.getStatus().equalsIgnoreCase("FAILED")) {
				List<TimeZoneApiEntity> zones = response.getZones();
				if (zones != null && zones.size() > 1) {
					for (TimeZoneApiEntity zone : zones) {
						if (zone.getCountryCode().equals(city.getCountryCode()) && zone.getRegionName().equalsIgnoreCase(city.getStateName())) {

							city.setTimeZoneAbbereviation(zone.getAbbreviation());
							regionDao.updateCity(city);
							count++;
						}
					}
				} else if (zones != null && zones.size() == 1) {

					city.setTimeZoneAbbereviation(zones.get(0).getAbbreviation());
					regionDao.updateCity(city);
					count++;
				}
			} else {
				failedCities.put(city, "No Record Found in timezone API \n");
			}
		}
		System.out.println("Total no of records updated : " + count);
		System.out.println("Failed cities : " + failedCities);
	}

	@Override
	public void updateCityWithOneTimeZone_LeftOut() {
		int count = 1;
		List<City> cities = regionDao.getAllCitiesWithTimeZoneNull();
		System.out.println("Total city found : " + cities.size());
		for (City city : cities) {

			City city1 = regionDao.getCityForCountryCodeWithTimeZoneAvailable(city.getCountryCode());
			if (city1 != null) {
				city.setTimeZoneAbbereviation(city1.getTimeZoneAbbereviation());

				regionDao.updateCity(city);
				count++;
			} else {
				System.out.println("City not updated : " + city);
			}
		}
		System.out.println("Total records update : " + count);
	}

	private TimeZoneApiResponse getTimeZones(String countryCode, String city) throws Exception {

		final HttpClient httpClient = HttpClientBuilder.create().build();
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("key", "PXRJC63IPDXV"));
		urlParameters.add(new BasicNameValuePair("format", "json"));
		urlParameters.add(new BasicNameValuePair("by", "city"));
		urlParameters.add(new BasicNameValuePair("country", countryCode));
		urlParameters.add(new BasicNameValuePair("city", city));
		// HttpGet httpGet = new
		// HttpGet("http://api.timezonedb.com/v2/list-time-zone");
		HttpGet httpGet = new HttpGet("http://vip.timezonedb.com/v2/get-time-zone");
		URI uri = new URIBuilder(httpGet.getURI()).addParameters(urlParameters).build();
		httpGet.setURI(uri);
		HttpResponse rawResponse = httpClient.execute(httpGet);
		String content = EntityUtils.toString(rawResponse.getEntity());
		ObjectMapper objectMapper = new ObjectMapper();
		TimeZoneApiResponse entity = objectMapper.readValue(content, TimeZoneApiResponse.class);
		System.out.println(content);
		return entity;
	}
}
