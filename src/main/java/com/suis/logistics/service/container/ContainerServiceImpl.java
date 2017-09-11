package com.suis.logistics.service.container;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;
import com.suis.logistics.repository.cargo.CargoDao;
import com.suis.logistics.repository.container.ContainerDao;

@Component
public class ContainerServiceImpl implements ContainerService {

	@Resource
	ContainerDao	containerDao;
	@Resource
	CargoDao		cargoDao;

	@Override
	public Integer createContainer(ContainerDetail containerDetail) {
		List<Cargo> cargoList = containerDetail.getCargos();
		if (!CollectionUtils.isEmpty(cargoList)) {
			for (Cargo cargo : cargoList) {
				containerDetail.addCargo(cargo);
			}
		}
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

	@Override
	public List<ContainerType> getContainerTypesByType(String type) {
		return containerDao.getContainerTypesByType(type);
	}
}
