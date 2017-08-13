package com.suis.logistics.service.commodity;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Commodity;
import com.suis.logistics.repository.commodity.CommodityDao;

@Component
public class CommodityServiceImpl implements CommodityService {

	@Resource
	CommodityDao commodityDao;

	@Override
	public Integer createCommodity(Commodity commodity) {
		return commodityDao.createCommodity(commodity);
	}

	@Override
	public Commodity getCommodity(int id) {
		return commodityDao.findById(id);
	}
}
