package com.suis.logistics.repository.incoterm;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.IncoTerm;
import com.suis.logistics.repository.BaseDao;

@Repository
public class IncoTermDaoImpl extends BaseDao implements IncoTermDao {

	@Override
	public Integer createIncoTerm(IncoTerm incoTerm) {
		getCurrentSession().save(incoTerm);
		return incoTerm.getId();
	}

	@Override
	public IncoTerm findById(int id) {
		return getCurrentSession().load(IncoTerm.class, id);
	}
}
