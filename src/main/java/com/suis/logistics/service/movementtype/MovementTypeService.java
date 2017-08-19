package com.suis.logistics.service.movementtype;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.MovementType;

@Transactional
public interface MovementTypeService {
	public Integer createMovementType(MovementType movementType);
	public MovementType getMovementType(int id);
	public List<MovementType> getAllMovementTypes();
}
