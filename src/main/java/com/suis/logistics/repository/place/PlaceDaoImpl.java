package com.suis.logistics.repository.place;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public Place findById(int id) {
		return getCurrentSession().load(Place.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> getAllPlaces() {

		Query query = getCurrentSession().getNamedQuery("Place.findAll");
		List<Place> places = query.list();
		return places;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> getPlacesByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Place.findByName").setParameter("name", name+"%");
		List<Place> places = query.list();
		return places;
	}
}
