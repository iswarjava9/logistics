package com.suis.logistics.repository.cargo;

import com.suis.logistics.model.Cargo;

public interface CargoDao {
	public Integer createCargo(Cargo cargo);

	public Cargo findById(int cargoId);
}
