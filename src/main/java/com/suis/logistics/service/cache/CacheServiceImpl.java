package com.suis.logistics.service.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.repository.booking.BookingDao;

@Component
public class CacheServiceImpl implements CacheService {

	@Autowired
	private CacheManager	cacheManager;
	@Resource
	BookingDao				bookingDao;

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
		} else {
			List<ContainerDetail> newContainerDetailList = new ArrayList<>();
			newContainerDetailList.add(containerDetail);
			bookingInCache.setContainerDetails(newContainerDetailList);
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

	@Override
	@CachePut(value = "BookingDetail", key = "#containerDetail.bookingDetail.id")
	public BookingDetail updateBookingDetailCacheOnUpdateContainerDetail(ContainerDetail containerDetail) {
		Cache cache = cacheManager.getCache("BookingDetail");
		ValueWrapper val = cache.get(containerDetail.getBookingDetail().getId());
		BookingDetail bookingInCache = null;
		bookingInCache = (BookingDetail) val.get();
		List<ContainerDetail> containerDetailList = bookingInCache.getContainerDetails();
		if (!CollectionUtils.isEmpty(containerDetailList)) {
			if (containerDetailList.contains(containerDetail)) {

				containerDetailList.remove(containerDetail);
				containerDetailList.add(containerDetail);
			}
		}
		return bookingInCache;
	}

	@Override
	@Cacheable(value = "BookingDetail", key = "#bookingDetail.id")
	public BookingDetail addBookingDetailToCacheOnBookingCreation(BookingDetail bookingDetail) {
		return bookingDetail;
	}

	@Override
	@SuppressWarnings("unchecked")
	@CachePut(value = "BookingList", key = "#root.targetClass")
	public List<BookingDetail> updateBookingListCache(BookingDetail booking) {
		String cacheName = "BookingList";
		BookingDetail bookingDetail = new BookingDetail();
		populateBookingDetailWithLessData(bookingDetail, booking);
		Cache cache = cacheManager.getCache(cacheName);
		Object nativeCache = cache.getNativeCache();
		Class<?> key = null;
		if (nativeCache instanceof net.sf.ehcache.Ehcache) {
			net.sf.ehcache.Ehcache ehCache = (net.sf.ehcache.Ehcache) nativeCache;
			if (!ehCache.getKeys().isEmpty()) {
				key = (Class<?>) ehCache.getKeys().get(0);
			}
		}
		if (key != null) {
			ValueWrapper val = cache.get(key);
			List<BookingDetail> bookings = (List<BookingDetail>) val.get();
			if (bookings.contains(bookingDetail)) {
				int index = bookings.indexOf(bookingDetail);
				bookings.remove(index);
				bookings.add(index, bookingDetail);
			} else {
				bookings.add(0, bookingDetail);
			}
			// cache.put(key, bookings);
			return bookings;
		}
		return null;
	}

	/**
	 * This method is used to populate bookingDetail with less data which is
	 * meant for displaying booking list. Refer getBookingList() method. If
	 * there is a change in getBookingList() method then this method also needs
	 * to be updated
	 *
	 * @param bookingDetail
	 * @param booking
	 */
	private void populateBookingDetailWithLessData(BookingDetail bookingDetail, BookingDetail booking) {
		bookingDetail.setId(booking.getId());
		bookingDetail.setCarrierBookingNo(booking.getCarrierBookingNo());
		bookingDetail.setShipperRefNo(booking.getShipperRefNo());
		bookingDetail.setBookingStatus(booking.getBookingStatus());
		bookingDetail.setNvoccBookingNo(booking.getNvoccBookingNo());
		bookingDetail.setForwarderRefNo(booking.getForwarderRefNo());
		bookingDetail.setBookingDate(booking.getBookingDate());
	}

	@Override
	@Cacheable(value = "BookingList", key = "#root.targetClass")
	public List<BookingDetail> getBookingList() {
		return bookingDao.getBookingList();
	}
}
