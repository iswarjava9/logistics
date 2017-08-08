package com.suis.logistics.repository.division;

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

}
