package com.suis.logistics.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.common.DateUtil;
import com.suis.logistics.service.common.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController extends BaseController {

	@Resource
	RegionService	regionService;
	@Resource
	DateUtil		dateUtil;

	@RequestMapping(value = "/city/byname/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<CityDto>> getCitiesByName(@PathVariable("name") String name) {
		List<CityDto> cities = converterUtil.convertCityListToDto(regionService.getCitiesByName(name));
		return new ResponseEntity<List<CityDto>>(cities, HttpStatus.OK);
	}

	@RequestMapping(value = "/timezones/{countryCode}", method = RequestMethod.GET)
	public ResponseEntity<List<TimeZoneDto>> getAllTimeZones(@PathVariable("countryCode") String countryCode) {
		List<TimeZoneDto> timeZones = converterUtil
				.convertListTimeZoneToDto(regionService.getAvailableTimeZonesByCountry(countryCode));
		return new ResponseEntity<List<TimeZoneDto>>(timeZones, HttpStatus.OK);
	}

	@RequestMapping(value = "/cities/timezone", method = RequestMethod.PUT)
	public ResponseEntity<Void> runTimeZoneEntry() {
      //regionService.updateCityWithOneTimeZone_LeftOut();
		regionService.updateCityWithTimeZoneForCountryWithMultipleTimeZone("");
		/*new Thread(() -> {
	  			regionService.updateCityWithTimeZoneForCountryWithMultipleTimeZone("");
		}).start();*/
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
