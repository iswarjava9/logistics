package com.suis.logistics.repository.container;



import org.springframework.stereotype.Repository;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;
import com.suis.logistics.repository.BaseDao;

@Repository
public class ContainerDaoImpl extends BaseDao implements ContainerDao {

	@Override
	public Integer createContainer(ContainerDetail containerDetail) {
		getCurrentSession().save(containerDetail);
		return containerDetail.getId();
	}

	@Override
	public ContainerDetail getContainer(int containerId) {
		return getCurrentSession().load(ContainerDetail.class, containerId);
	}

	@Override
	public Integer createContainerType(ContainerType containerType) {
		getCurrentSession().save(containerType);
		return containerType.getId();
	}

	@Override
	public ContainerType getContainerType(int containerTypeId) {
		return getCurrentSession().load(ContainerType.class, containerTypeId);
	}


}
