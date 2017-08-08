package com.suis.logistics.repository.place;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Place;
import com.suis.logistics.repository.BaseDao;

@Repository
public class PlaceDaoImpl extends BaseDao implements PlaceDao {

	@Override
	public Integer createPlace(Place place) {
		getCurrentSession().save(place);
		return place.getId();
	}

}
