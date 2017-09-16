package com.suis.logistics.repository.booking;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
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
		clearCache("bookingList");
		return bookingDetail;
	}

	@Override
	public BookingDetail updateBooking(BookingDetail bookingDetail) {
		try {
			getCurrentSession().update(bookingDetail);
		} catch (Exception e) {
			throw new UpdateBookingFailedException(e, env);
		}
		return bookingDetail;
	}

	@Override
	public BookingDetail findById(int bookingId) {

		return getCurrentSession().load(BookingDetail.class, bookingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value = "bookingList")
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
