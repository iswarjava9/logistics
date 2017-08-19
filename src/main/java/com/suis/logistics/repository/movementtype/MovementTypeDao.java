package com.suis.logistics.repository.movementtype;

import java.util.List;

import com.suis.logistics.model.MovementType;

public interface MovementTypeDao {
	public Integer createMovementType(MovementType movementType);

	public MovementType findById(int movementTypeId);
	public List<MovementType> getAllMovementTypes();
}
