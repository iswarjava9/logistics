package com.suis.logistics.service.container;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;


@Transactional
public interface ContainerService {

	public Integer createContainer(ContainerDetail containerDetail);

	public ContainerDetail getContainer(int id);

	public Integer createContainerType(ContainerType containerType);

	public ContainerType getContainerType(int id);

}
