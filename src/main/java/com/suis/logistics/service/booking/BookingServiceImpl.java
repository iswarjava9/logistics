package com.suis.logistics.service.booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.suis.logistics.common.UniqueKeyGenerator;
import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.booking.BookingDao;

@Component
public class BookingServiceImpl implements BookingService {

	@Resource
	BookingDao			bookingDao;
	@Resource
	UniqueKeyGenerator	keyGenerator;
	@Value("${bookingno.ocean.export.prefix}")
	private String		bookingNoOceanExportPrefix;

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
		String bookingNo = keyGenerator.generateUniqueKey(bookingNoOceanExportPrefix, lastId);
		return bookingNo;
	}

	@Override
	public InputStream downloadBookingConfirmation(String bookingNo, HttpHeaders headers) throws IOException {
		File pdf = new File(
				"C://My Drive//WORKSPACEs//Logistics//logistics//src//main//resources//generated-pdf//booking-"
						+ bookingNo + ".pdf");
		/*ClassPathResource bookingPDF = new ClassPathResource("generated-pdf/" + pdf.getName());*/
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "inline; filename=" + pdf.getName());
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(pdf.length());
		InputStream  bookingPDF= new FileInputStream(pdf);
		return bookingPDF;
	}

}
