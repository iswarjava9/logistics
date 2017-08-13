package com.suis.logistics.service.commodity;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Commodity;

@Transactional
public interface CommodityService {

	public Integer createCommodity(Commodity commodity);
	public Commodity getCommodity(int id);
}
