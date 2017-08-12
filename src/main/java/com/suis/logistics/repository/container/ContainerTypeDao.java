package com.suis.logistics.repository.container;

import com.suis.logistics.model.ContainerType;

public interface ContainerTypeDao {
	public Integer createContainerType(ContainerType containerType);

	public ContainerType findById(int containerTypeId);
}
