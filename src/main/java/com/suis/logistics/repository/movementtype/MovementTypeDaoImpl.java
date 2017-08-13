package com.suis.logistics.repository.movementtype;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.MovementType;
import com.suis.logistics.repository.BaseDao;

@Repository
public class MovementTypeDaoImpl extends BaseDao implements MovementTypeDao {

	@Override
	public Integer createMovementType(MovementType movementType) {
		getCurrentSession().save(movementType);
		return movementType.getId();
	}

	@Override
	public MovementType findById(int id) {
		return getCurrentSession().load(MovementType.class, id);
	}
}
