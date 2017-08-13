package com.suis.logistics.service.movementtype;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.MovementType;

@Transactional
public interface MovementTypeService {
	public Integer createMovementType(MovementType movementType);
	public MovementType getMovementType(int id);
}
