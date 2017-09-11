package com.suis.logistics.repository.container;



import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ContainerType> getContainerTypesByType(String type) {
		Query query = getCurrentSession().getNamedQuery("ContainerType.findByType").setParameter("type", type + "%");
		List<ContainerType> containerTypes = query.list();

		return containerTypes;
	}



}
