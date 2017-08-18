package com.suis.logistics.service.place;

import java.util.List;

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

	@Override
	public Place getPlace(int id) {
		return placeDao.findById(id);
	}

	@Override
	public List<Place> getAllPlaces() {
		return placeDao.getAllPlaces();
	}
}
