package com.suis.logistics.repository.servicelevel;

import com.suis.logistics.model.ServiceLevel;

public interface ServiceLevelDao {
	public Integer createServiceLevel(ServiceLevel serviceLevel);

	public ServiceLevel findById(int serviceLevelId);
}
