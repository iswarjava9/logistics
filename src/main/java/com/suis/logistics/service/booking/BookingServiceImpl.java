package com.suis.logistics.service.booking;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.booking.BookingDao;
import com.suis.logistics.service.UniqueKeyGenerator;

@Component
public class BookingServiceImpl implements BookingService {

	@Resource
	BookingDao			bookingDao;
	@Resource
	UniqueKeyGenerator	keyGenerator;
	@Value("${booking.no.prefix}")
	private String		bookingNoPrefix;

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

	@Override
	public InputStream downloadBookingConfirmation(String bookingNo, HttpHeaders headers) throws IOException {
		String fileName = "booking-" + bookingNo + ".pdf";
		ClassPathResource bookingPDF = new ClassPathResource("generated-pdf/" + fileName);
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "inline; filename=" + fileName);
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(bookingPDF.contentLength());
		return bookingPDF.getInputStream();
	}
}
