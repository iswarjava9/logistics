package com.suis.logistics.repository.movementtype;

import com.suis.logistics.model.MovementType;

public interface MovementTypeDao {
	public Integer createMovementType(MovementType movementType);

	public MovementType findById(int movementTypeId);
}
