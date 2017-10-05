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
import com.suis.logistics.service.cache.CacheService;

@Component
public class ContainerServiceImpl implements ContainerService {

	@Resource
	private ContainerDao	containerDao;
	@Resource
	private CargoDao		cargoDao;
	@Resource
	private CacheService	cacheService;

	@Override
	public Integer createContainer(ContainerDetail containerDetail) {
		List<Cargo> cargoList = containerDetail.getCargos();
		if (!CollectionUtils.isEmpty(cargoList)) {
			for (Cargo cargo : cargoList) {
				containerDetail.addCargo(cargo);
			}
		}
		Integer containerId = containerDao.createContainer(containerDetail);
		cacheService.updateBookingDetailCacheOnAddContainerDetail(containerDetail);
		return containerId;
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

	@Override
	public ContainerDetail deleteContainer(int containerId) {
		ContainerDetail containerDetail = containerDao.deleteContainer(containerId);
		cacheService.updateBookingDetailCacheOnDeleteContainerDetail(containerDetail);
		return containerDetail;
	}

	@Override
	public ContainerDetail updateContainer(ContainerDetail containerDetail) {
		ContainerDetail containerDetailUpdated = containerDao.updateContainer(containerDetail);
		cacheService.updateBookingDetailCacheOnUpdateContainerDetail(containerDetailUpdated);
		return containerDetail;
	}
}
