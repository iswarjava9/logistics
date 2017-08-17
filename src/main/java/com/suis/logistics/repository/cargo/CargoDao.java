package com.suis.logistics.repository.cargo;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.ContainerDetail;

public interface CargoDao {
	public Integer createCargo(Cargo cargo);

	public Cargo findById(int cargoId);

	public void loadCargoAndAttachToContainerDetail(ContainerDetail containerDetail);
}
