package com.suis.logistics.service.booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.suis.logistics.common.UniqueKeyGenerator;
import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.Customer;
import com.suis.logistics.model.thirdparty.ThirdPartyAddress;
import com.suis.logistics.model.thirdparty.ThirdPartyCustomer;
import com.suis.logistics.model.thirdparty.ThirdPartyPerson;
import com.suis.logistics.repository.booking.BookingDao;
import com.suis.logistics.service.cache.CacheService;
import com.suis.logistics.service.customer.CustomerService;
import com.suis.logistics.service.customer.ThirdPartyCustomerService;

@Component
public class BookingServiceImpl implements BookingService {

	@Resource
	BookingDao					bookingDao;
	@Resource
	UniqueKeyGenerator			keyGenerator;
	@Resource
	CacheService				cacheService;
	@Value("${bookingno.ocean.export.prefix}")
	private String				bookingNoOceanExportPrefix;
	@Value("${booking.pdf.url}")
	private String				bookingPDFUrl;
	@Resource
	ThirdPartyCustomerService	tpCustomerService;
	@Resource
	CustomerService				customerService;

	@Override
	public BookingDetail createBooking(BookingDetail bookingDetail) {
		String bookingNo = generateUniqueBookingNo();
		bookingDetail.setNvoccBookingNo(bookingNo);
		bookingDetail.setForwarderRefNo(bookingNo);
		bookingDetail.setBookingDate(LocalDateTime.now());
		BookingDetail bookingDetailCreated = bookingDao.createBooking(bookingDetail);
		cacheService.addBookingDetailToCacheOnBookingCreation(bookingDetail);
		// Create Customer in Zoho Books for BillTo which is required to create
		// a invoice in Zoho
		Customer billTo = bookingDetail.getBillTo();
		if (billTo.getTpCustomerId() == null) {
			createThirdPartyCustomer(billTo);
		}
		return bookingDetailCreated;
	}

	private ThirdPartyCustomer populateThirdPartyCustomer(Customer customer) {
		ThirdPartyCustomer tpCustomer = new ThirdPartyCustomer();
		tpCustomer.setContactType("customer");
		tpCustomer.setCompanyName(customer.getName());
		tpCustomer.setContactName(customer.getName());
		List<ThirdPartyPerson> contacts = new ArrayList<>();
		ThirdPartyPerson contact1 = new ThirdPartyPerson();
		contact1.setEmail(customer.getEmailId());
		contact1.setIsPrimaryContact(true);
		contact1.setPhone(customer.getPhoneNo());
		contact1.setFirstName(customer.getPersonInCharge());
		contacts.add(contact1);
		tpCustomer.setContacts(contacts);
		ThirdPartyAddress billingAddress = new ThirdPartyAddress();
		billingAddress.setAddress(customer.getAddress());
		billingAddress.setCity(customer.getCity().getName());
		billingAddress.setCountry(customer.getCity().getCountryName());
		billingAddress.setState(customer.getCity().getStateName());
		tpCustomer.setBillingAddress(billingAddress);
		tpCustomer.setShippingAddress(billingAddress);
		return tpCustomer;
	}

	@Override
	public BookingDetail updateBooking(BookingDetail bookingDetail) {
		bookingDetail.setAmendmentDate(LocalDateTime.now());
		BookingDetail updatedBookingDetail = bookingDao.updateBooking(bookingDetail);
		Customer billTo = updatedBookingDetail.getBillTo();
		if (billTo.getTpCustomerId() == null) {
			createThirdPartyCustomer(billTo);
		}
		return updatedBookingDetail;
	}

	private void createThirdPartyCustomer(Customer customer) {
		ThirdPartyCustomer tpCustomerResponse = tpCustomerService.createCustomer(populateThirdPartyCustomer(customer));
		if (tpCustomerResponse != null) {
			customer.setTpCustomerId(tpCustomerResponse.getCustomerId());
			customerService.updateCustomer(customer);
		}
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
		if (lastId == null) {
			lastId = 0;
		}
		String bookingNo = keyGenerator.generateUniqueKey(bookingNoOceanExportPrefix, lastId);
		return bookingNo;
	}

	@Override
	public InputStream downloadBookingConfirmation(String bookingNo, HttpHeaders headers) throws IOException {
		File pdf = new File(bookingPDFUrl + "//booking-" + bookingNo + ".pdf");
		/*
		 * ClassPathResource bookingPDF = new ClassPathResource("generated-pdf/"
		 * + pdf.getName());
		 */
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "inline; filename=" + pdf.getName());
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(pdf.length());
		InputStream bookingPDF = new FileInputStream(pdf);
		return bookingPDF;
	}
}
