package com.suis.logistics.service.cache;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.ContainerDetail;

public interface CacheService {

	BookingDetail updateBookingDetailCacheOnAddContainerDetail(ContainerDetail containerDetail);
	BookingDetail updateBookingDetailCacheOnDeleteContainerDetail(ContainerDetail containerDetail);
}
