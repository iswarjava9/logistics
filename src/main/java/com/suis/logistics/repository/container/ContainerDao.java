package com.suis.logistics.repository.container;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;

public interface ContainerDao {

	public Integer createContainer(ContainerDetail containerDetail);
	public ContainerDetail getContainer(int containerId);
	public Integer createContainerType(ContainerType containerType);
	public ContainerType getContainerType(int containerTypeId);
}
