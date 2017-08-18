package com.suis.logistics.web.place;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<PlaceDto> get(@PathVariable("id") int id) {

		PlaceDto placeDto = converterUtil.convertPlaceToDto(placeService.getPlace(id));
		return new ResponseEntity<PlaceDto>(placeDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<PlaceDto>> getBookingList() {
		List<PlaceDto> places = converterUtil.convertPlaceListToDto(placeService.getAllPlaces());
		return new ResponseEntity<List<PlaceDto>>(places, HttpStatus.OK);
	}
}
