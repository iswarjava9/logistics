package com.suis.logistics.repository.commodity;

import com.suis.logistics.model.Commodity;

public interface CommodityDao {
	public Integer createCommodity(Commodity commodity);

	public Commodity findById(int commodityId);
}
