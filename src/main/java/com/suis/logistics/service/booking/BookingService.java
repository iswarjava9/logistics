package com.suis.logistics.service.booking;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.BookingDetail;

@Transactional(propagation=Propagation.REQUIRED)
public interface BookingService {
	public Integer createBooking(BookingDetail bookingDetail);

	public BookingDetail getBookingDetail(int id);

	public List<BookingDetail> getBookingList();

}
