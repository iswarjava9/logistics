package com.suis.logistics.service.place;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Place;

@Transactional
public interface PlaceService {

	public Integer addPlace(Place place);
	public Place getPlace(int id);
	public List<Place> getAllPlaces();
	public List<Place> getPlacesByName(String name);
}
