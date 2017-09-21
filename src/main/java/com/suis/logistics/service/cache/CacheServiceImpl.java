package com.suis.logistics.service.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.ContainerDetail;

@Component
public class CacheServiceImpl implements CacheService {

	@Autowired
	private CacheManager cacheManager;

	@Override
	@CachePut(value = "BookingDetail", key = "#containerDetail.bookingDetail.id")
	public BookingDetail updateBookingDetailCacheOnAddContainerDetail(ContainerDetail containerDetail) {
		Cache cache = cacheManager.getCache("BookingDetail");
		ValueWrapper val = cache.get(containerDetail.getBookingDetail().getId());
		BookingDetail bookingInCache = null;
		bookingInCache = (BookingDetail) val.get();
		List<ContainerDetail> containerDetailList = bookingInCache.getContainerDetails();
		if (containerDetailList != null) {
			containerDetailList.add(containerDetail);
		}
		return bookingInCache;
	}

	@Override
	public BookingDetail updateBookingDetailCacheOnDeleteContainerDetail(ContainerDetail containerDetail) {
		Cache cache = cacheManager.getCache("BookingDetail");
		ValueWrapper val = cache.get(containerDetail.getBookingDetail().getId());
		BookingDetail bookingInCache = null;
		bookingInCache = (BookingDetail) val.get();
		List<ContainerDetail> containerDetailList = bookingInCache.getContainerDetails();
		if (containerDetailList != null && containerDetailList.contains(containerDetail)) {
			containerDetailList.remove(containerDetail);
		}
		return bookingInCache;
	}

}
