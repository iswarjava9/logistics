package com.suis.logistics.repository.booking;

import java.util.List;

import com.suis.logistics.model.BookingDetail;

public interface BookingDao {
	public BookingDetail createBooking(BookingDetail bookingDetail);

	public BookingDetail updateBooking(BookingDetail bookingDetail);

	public BookingDetail findById(int bookingId);

	public List<BookingDetail> getBookingList();

	public Integer getLastInsertedPrimaryKey();
}
