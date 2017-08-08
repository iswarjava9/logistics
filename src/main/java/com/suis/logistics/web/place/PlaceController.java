package com.suis.logistics.web.place;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.place.PlaceService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/place")
public class PlaceController extends BaseController {

	@Resource
	PlaceService placeService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addPlace(@RequestBody PlaceDto placeDto) {

		Integer placeId = placeService.addPlace(converterUtil.convertPlaceDtoToEntity(placeDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("placeId", String.valueOf(placeId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
