package com.suis.logistics.repository.booking;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.BaseDao;

@Repository
public class BookingDaoImpl extends BaseDao implements BookingDao {

	@Override
	public Integer createBooking(BookingDetail bookingDetail) {
		getCurrentSession().save(bookingDetail);
		return bookingDetail.getId();
	}

	@Override
	public BookingDetail findById(int bookingId) {

		return (BookingDetail) getCurrentSession().load(BookingDetail.class, bookingId);
	}
}
