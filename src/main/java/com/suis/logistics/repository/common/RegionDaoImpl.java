package com.suis.logistics.repository.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.City;
import com.suis.logistics.model.TimeZone;
import com.suis.logistics.repository.BaseDao;

@Repository
public class RegionDaoImpl extends BaseDao implements RegionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitiesByName(String name) {
		Query query = getCurrentSession().getNamedQuery("City.findByName").setParameter("name", name + "%");
		List<City> allCities = query.list();
		for(City city : allCities){
			city.setName(city.getName()+"  "+city.getStateName()+"  "+city.getCountryName());
		}
		return allCities;
	}

	@Override
	public List<City> getAllCitiesWithTimeZoneNull() {
		/*
		 * Query query = getCurrentSession().getNamedQuery("City.findAll");
		 * query.setFirstResult(firstResult); query.setMaxResults(maxResult);
		 * List<City> allCities = query.list();
		 */
		Criteria cr = getCurrentSession().createCriteria(City.class, "city");
		cr.addOrder(Order.asc("id"));
		//cr.setMaxResults(maxResult);
		//cr.setFirstResult(firstResult);
		/*cr.add(Restrictions.isNull("city.timeZoneId"));
		cr.createAlias("city.state", "state");
		cr.createAlias("state.country", "country");
		cr.add(Restrictions.and(Restrictions.in("country.code", new String[] {"US"})));*/
		/*cr.add(Restrictions
				.not(Restrictions
						.in("country.code",
								new String[] { "US","FR", "RU", "AQ", "AU", "GB", "CA", "DK", "NZ", "BR", "MX", "CL",
										"ID", "KI", "CY", "CD", "EC", "FM", "KZ", "NL", "MN", "PG", "PT", "ZA", "ES",
										"UA" })));
*/
		return cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeZone> findAvailableTimeZonesByCountry(String countryCode) {
		Query query = getCurrentSession().getNamedQuery("TimeZones.findByCountryCode").setParameter("countryCode",
				countryCode);
		List<TimeZone> timeZones = query.list();
		return timeZones;
	}

	@Override
	public List<TimeZone> getAllTimeZones() {
		Query query = getCurrentSession().getNamedQuery("TimeZone.findAll");
		List<TimeZone> timeZones = query.list();
		return timeZones;
	}

	@Override
	public void updateCity(City city) {
		getCurrentSession().update(city);
		System.out.println(" --------------------------------- Updating City Successful :- " + city);
	}

	@Override
	public City getCityForCountryCodeWithTimeZoneAvailable(String countryCode) {
		Criteria cr = getCurrentSession().createCriteria(City.class, "city");
		cr.addOrder(Order.asc("id"));
		//cr.setMaxResults(maxResult);
		//cr.setFirstResult(firstResult);
		cr.add(Restrictions.isNotNull("city.timeZoneId"));
		cr.createAlias("city.state", "state");
		cr.createAlias("state.country", "country");
		cr.add(Restrictions.eq("country.code", countryCode));
        if (cr.list().isEmpty()){
        	return null;
        }
		return (City) cr.list().get(0);
	}
}
