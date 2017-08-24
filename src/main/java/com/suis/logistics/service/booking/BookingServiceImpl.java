package com.suis.logistics.service.booking;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.booking.BookingDao;
import com.suis.logistics.service.UniqueKeyGenerator;

@Component
public class BookingServiceImpl implements BookingService {

	@Resource
	BookingDao bookingDao;

	@Resource
	UniqueKeyGenerator keyGenerator;

	@Value("${booking.no.prefix}")
	private String bookingNoPrefix;

	@Override
	public BookingDetail createBooking(BookingDetail bookingDetail) {
		String bookingNo = generateUniqueBookingNo();
		bookingDetail.setNvoccBookingNo(bookingNo);
		bookingDetail.setForwarderRefNo(bookingNo);
		return bookingDao.createBooking(bookingDetail);
	}

	@Override
	public BookingDetail getBookingDetail(int bookingId) {
		BookingDetail bookingDetail = bookingDao.findById(bookingId);
		return bookingDetail;
	}

	@Override
	public List<BookingDetail> getBookingList() {
		return bookingDao.getBookingList();
	}

	@Override
	public String generateUniqueBookingNo() {
		Integer lastId = bookingDao.getLastInsertedPrimaryKey();
		String bookingNo = keyGenerator.generateUniqueKey(bookingNoPrefix, lastId);
		return bookingNo;
	}


}
