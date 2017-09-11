package com.suis.logistics.service.booking;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.BookingDetail;

@Transactional(propagation=Propagation.REQUIRED)
public interface BookingService {
	public BookingDetail createBooking(BookingDetail bookingDetail);

	public BookingDetail updateBooking(BookingDetail bookingDetail);

	public BookingDetail getBookingDetail(int id);

	public List<BookingDetail> getBookingList();

	public String generateUniqueBookingNo();

	public InputStream downloadBookingConfirmation(String bookingNo,HttpHeaders headers) throws IOException;
}
