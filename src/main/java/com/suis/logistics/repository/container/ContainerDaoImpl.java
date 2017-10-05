package com.suis.logistics.repository.container;



import java.util.List;

import org.hibernate.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;
import com.suis.logistics.repository.BaseDao;

@Repository
public class ContainerDaoImpl extends BaseDao implements ContainerDao {

	@Override
	public Integer createContainer(ContainerDetail containerDetail) {
		getCurrentSession().save(containerDetail);
		clearCache("containerTypeByType");
		return containerDetail.getId();
	}

	@Override
	public ContainerDetail getContainer(int containerId) {
		return getCurrentSession().load(ContainerDetail.class, containerId);
	}

	@Override
	public ContainerDetail deleteContainer(int containerId) {
		ContainerDetail container = getCurrentSession().load(ContainerDetail.class, containerId);
		getCurrentSession().delete(container);
		return container;
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

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value = "containerTypeByType", key = "#type")
	public List<ContainerType> getContainerTypesByType(String type) {
		Query query = getCurrentSession().getNamedQuery("ContainerType.findByType").setParameter("type", type + "%");
		List<ContainerType> containerTypes = query.list();

		return containerTypes;
	}

	@Override
	public ContainerDetail updateContainer(ContainerDetail containerDetail) {
		getCurrentSession().update(containerDetail);
		return containerDetail;
	}



}
