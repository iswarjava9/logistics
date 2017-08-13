package com.suis.logistics.service.container;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;
import com.suis.logistics.repository.container.ContainerDao;

@Component
public class ContainerServiceImpl implements ContainerService {

@Resource
ContainerDao containerDao;

	@Override
	public Integer createContainer(ContainerDetail containerDetail) {
		return containerDao.createContainer(containerDetail);
	}

	@Override
	public ContainerDetail getContainer(int id) {
		return containerDao.getContainer(id);
	}

	@Override
	public Integer createContainerType(ContainerType containerType) {
		return containerDao.createContainerType(containerType);
	}

	@Override
	public ContainerType getContainerType(int id) {
		return containerDao.getContainerType(id);
	}


}
