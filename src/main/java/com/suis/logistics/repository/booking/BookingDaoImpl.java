package com.suis.logistics.repository.booking;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.BaseDao;

@Repository
public class BookingDaoImpl extends BaseDao implements BookingDao {

	@Autowired
	Environment env;

	@Override
	public BookingDetail createBooking(BookingDetail bookingDetail) {
		try {
			getCurrentSession().save(bookingDetail);
			// bookingDetail.getUser().getId();// simulate booking creation
			// exception scenario
		} catch (Exception e) {
			// bookingDetail.getUser().getId(); // Simulate unknown error
			throw new CreateBookingFailedException(e, env);
		}
		updateCache("BookingList", bookingDetail);
		return bookingDetail;
	}

	@SuppressWarnings("unchecked")
	@CachePut(value = "BookingList", key = "#root.targetClass")
	public List<BookingDetail> updateCache(String cacheName, BookingDetail booking) {
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
	@CachePut(value = "BookingDetail", key = "#bookingDetail.id")
	public BookingDetail updateBooking(BookingDetail bookingDetail) {
		try {
			getCurrentSession().update(bookingDetail);
		} catch (Exception e) {
			throw new UpdateBookingFailedException(e, env);
		}
		updateCache("BookingList", bookingDetail);
		return bookingDetail;
	}

	@Override
	@Cacheable(value = "BookingDetail", key = "#bookingId")
	public BookingDetail findById(int bookingId) {
		BookingDetail bookingDetail = null;
		try {
			bookingDetail = getCurrentSession().load(BookingDetail.class, bookingId);
			bookingDetail.getId();
		} catch (ObjectNotFoundException e) {
			throw new BookingNotFoundException(e, env);
		}
		return bookingDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value = "BookingList", key = "#root.targetClass")
	public List<BookingDetail> getBookingList() {
		Criteria cr = getCurrentSession().createCriteria(BookingDetail.class)
				.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("carrierBookingNo"), "carrierBookingNo")
						.add(Projections.property("shipperRefNo"), "shipperRefNo")
						.add(Projections.property("bookingStatus"), "bookingStatus")
						.add(Projections.property("nvoccBookingNo"), "nvoccBookingNo")
						.add(Projections.property("forwarderRefNo"), "forwarderRefNo")
						.add(Projections.property("bookingDate"), "bookingDate"))
				.addOrder(Order.desc("bookingDate"))
				.setResultTransformer(Transformers.aliasToBean(BookingDetail.class));
		List<BookingDetail> list = cr.list();
		return list;
	}

	@Override
	public Integer getLastInsertedPrimaryKey() {
		Query query = getCurrentSession().getNamedQuery("BookingDetail.findLastPrimaryKey");
		Integer lastBookingId = (Integer) query.uniqueResult();
		return lastBookingId;
	}
}
