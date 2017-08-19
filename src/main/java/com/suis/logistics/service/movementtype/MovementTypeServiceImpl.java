package com.suis.logistics.service.movementtype;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.MovementType;
import com.suis.logistics.repository.movementtype.MovementTypeDao;

@Component
public class MovementTypeServiceImpl implements MovementTypeService {
	@Resource
	MovementTypeDao movementTypeDao;

	@Override
	public Integer createMovementType(MovementType movementType) {
		return movementTypeDao.createMovementType(movementType);
	}

	@Override
	public MovementType getMovementType(int id) {
		return movementTypeDao.findById(id);
	}

	@Override
	public List<MovementType> getAllMovementTypes() {
		return movementTypeDao.getAllMovementTypes();
	}
}
