package com.suis.logistics.repository.container;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.repository.BaseDao;

@Repository
public class ContainerDaoImpl extends BaseDao implements ContainerDao {

	@Override
	public Integer createContainer(ContainerDetail containerDetail) {
		getCurrentSession().save(containerDetail);
		return containerDetail.getId();
	}
}
