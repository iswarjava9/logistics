package com.suis.logistics.repository.commodity;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Commodity;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CommodityDaoImpl extends BaseDao implements CommodityDao{

	@Override
	public Integer createCommodity(Commodity commodity) {
		getCurrentSession().save(commodity);
		return commodity.getId();
	}

	@Override
	public Commodity findById(int commodityId) {
		return getCurrentSession().load(Commodity.class, commodityId);
	}

}
