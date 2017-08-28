package com.suis.logistics.repository.place;

import java.util.List;

import com.suis.logistics.model.Place;

public interface PlaceDao {
	public Integer createPlace(Place place);

	public Place findById(int id);

	public List<Place> getAllPlaces();

	public List<Place> getPlacesByName(String name);
}
