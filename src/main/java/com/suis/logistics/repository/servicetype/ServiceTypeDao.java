package com.suis.logistics.repository.servicetype;

import com.suis.logistics.model.ServiceType;

public interface ServiceTypeDao {
	public Integer createServiceType(ServiceType serviceType);

	public ServiceType findById(int serviceTypeId);
}
