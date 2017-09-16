package com.suis.logistics.repository.commodity;

import java.util.List;

import org.hibernate.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Commodity;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CommodityDaoImpl extends BaseDao implements CommodityDao{

	@Override
	public Integer createCommodity(Commodity commodity) {
		getCurrentSession().save(commodity);
		clearCache("commodityByName");
		return commodity.getId();
	}

	@Override
	public Commodity findById(int commodityId) {
		return getCurrentSession().load(Commodity.class, commodityId);
	}

	@Override
	@Cacheable(value = "commodityByName", key = "#type")
	public List<Commodity> findCommodityByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Commodity.findByName").setParameter("name", name + "%");
		List<Commodity> commodities = query.list();
		return commodities;
	}

}
