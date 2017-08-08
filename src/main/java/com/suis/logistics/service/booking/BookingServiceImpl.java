package com.suis.logistics.service.booking;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.booking.BookingDao;

@Component
public class BookingServiceImpl implements BookingService {

	@Resource
	BookingDao bookingDao;

	@Override
	public Integer createBooking(BookingDetail bookingDetail) {
		return bookingDao.createBooking(bookingDetail);
	}

	@Override
	public BookingDetail getBookingDetail(int bookingId) {
		return bookingDao.findById(bookingId);
	}
}
