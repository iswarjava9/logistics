package com.suis.logistics.service.place;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Place;

@Transactional
public interface PlaceService {

	public Integer addPlace(Place place);
}
