package com.suis.logistics.repository.container;

import java.util.List;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;

public interface ContainerDao {

	public Integer createContainer(ContainerDetail containerDetail);
	public ContainerDetail updateContainer(ContainerDetail containerDetail);
	public ContainerDetail getContainer(int containerId);
	public ContainerDetail deleteContainer(int containerId);
	public Integer createContainerType(ContainerType containerType);
	public ContainerType getContainerType(int containerTypeId);
	public List<ContainerType> getContainerTypesByType(String type);


}
