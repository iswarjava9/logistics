package com.suis.logistics.service.cache;

import java.util.List;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.ContainerDetail;

public interface CacheService {

	BookingDetail updateBookingDetailCacheOnAddContainerDetail(ContainerDetail containerDetail);
	BookingDetail updateBookingDetailCacheOnUpdateContainerDetail(ContainerDetail containerDetail);
	BookingDetail updateBookingDetailCacheOnDeleteContainerDetail(ContainerDetail containerDetail);
	BookingDetail addBookingDetailToCacheOnBookingCreation(BookingDetail bookingDetail);
	List<BookingDetail> updateBookingListCache(BookingDetail bookingDetail);
}
