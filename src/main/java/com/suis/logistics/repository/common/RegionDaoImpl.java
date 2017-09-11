package com.suis.logistics.repository.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.City;
import com.suis.logistics.repository.BaseDao;

@Repository
public class RegionDaoImpl extends BaseDao implements RegionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitiesByName(String name) {
		Query query = getCurrentSession().getNamedQuery("City.findByName").setParameter("name", name + "%");
		List<City> allCities = query.list();
		return allCities;
	}
}
