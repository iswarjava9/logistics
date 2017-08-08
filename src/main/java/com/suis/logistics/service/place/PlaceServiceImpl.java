package com.suis.logistics.service.place;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Place;
import com.suis.logistics.repository.place.PlaceDao;

@Component
public class PlaceServiceImpl implements PlaceService {

	@Resource
	PlaceDao placeDao;

	@Override
	public Integer addPlace(Place place) {
		return placeDao.createPlace(place);
	}
}
