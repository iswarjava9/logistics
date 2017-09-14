package com.suis.logistics.service.container;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;


@Transactional(propagation = Propagation.REQUIRED)
public interface ContainerService {

	public Integer createContainer(ContainerDetail containerDetail);

	public ContainerDetail getContainer(int id);

	public Integer createContainerType(ContainerType containerType);

	public ContainerType getContainerType(int id);

	public List<ContainerType> getContainerTypesByType(String type);
	
	public ContainerDetail deleteContainer(int id);

}
