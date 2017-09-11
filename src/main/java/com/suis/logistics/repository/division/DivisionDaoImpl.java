package com.suis.logistics.repository.division;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Division;
import com.suis.logistics.repository.BaseDao;

@Repository
public class DivisionDaoImpl extends BaseDao implements DivisionDao {

	@Override
	public Integer createDivision(Division division) {
		getCurrentSession().save(division);
		return division.getId();
	}

	@Override
	public Division findById(int id) {
		return getCurrentSession().load(Division.class, id);
	}

	@Override
	public List<Division> getDivisionsByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Division.findByName").setParameter("name", name + "%");
		List<Division> divisionList = query.list();
		return divisionList;
	}
}
