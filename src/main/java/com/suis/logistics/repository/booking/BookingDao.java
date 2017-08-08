package com.suis.logistics.repository.booking;

import com.suis.logistics.model.BookingDetail;

public interface BookingDao {
	public Integer createBooking(BookingDetail bookingDetail);

	public BookingDetail findById(int bookingId);
}
