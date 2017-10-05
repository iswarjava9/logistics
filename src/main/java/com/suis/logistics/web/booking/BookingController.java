package com.suis.logistics.web.booking;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.common.PDFGeneratorUtil;
import com.suis.logistics.service.booking.BookingService;
import com.suis.logistics.service.invoice.Invoice;
import com.suis.logistics.service.invoice.InvoiceService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController {
	@Resource
	BookingService		bookingService;
	@Resource
	InvoiceService		invoiceService;
	@Resource
	PDFGeneratorUtil	pdfGeneratorUtil;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {

		BookingDto bookingDtoResponse = converterUtil.convertBookingDetailToDto(
				bookingService.createBooking(converterUtil.convertBookingDtoToEntity(bookingDto)));
		String remarks = bookingDtoResponse.getRemarks();
		if (remarks != null) {
			bookingDtoResponse.setRemarks(remarks.replace("\\n", "\n"));
		}
		return new ResponseEntity<BookingDto>(bookingDtoResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto) {

		BookingDto bookingDtoResponse = converterUtil.convertBookingDetailToDto(
				bookingService.updateBooking(converterUtil.convertBookingDtoToEntity(bookingDto)));
		String remarks = bookingDtoResponse.getRemarks();
		if (remarks != null) {
			bookingDtoResponse.setRemarks(remarks.replace("\\n", "\n"));
		}
		return new ResponseEntity<BookingDto>(bookingDtoResponse, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<BookingDto> get(@PathVariable("id") int id) {

		BookingDto bookingDto = converterUtil.convertBookingDetailToDto(bookingService.getBookingDetail(id));
		converterUtil.convertDateTimeFromUTCtoPlaceTimeZone(bookingDto);
		String remarks = bookingDto.getRemarks();
		if (remarks != null) {
			bookingDto.setRemarks(remarks.replace("\\n", "\n"));
		}
		// generateBookingXml(bookingDto);
		return new ResponseEntity<BookingDto>(bookingDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<BookingDto>> getBookingList() {
		List<BookingDto> bookings = converterUtil.convertBookingDetailToDtoList(bookingService.getBookingList());
		return new ResponseEntity<List<BookingDto>>(bookings, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> download(@PathVariable("id") int id) throws Exception {
		BookingDto bookingDto = converterUtil.convertBookingDetailToDto(bookingService.getBookingDetail(id));
		pdfGeneratorUtil.generateBookingConfirmationPDF(bookingDto);
		HttpHeaders headers = new HttpHeaders();
		InputStream bookingConfirmationPDF = bookingService.downloadBookingConfirmation(bookingDto.getForwarderRefNo(),
				headers);
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(bookingConfirmationPDF), headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public ResponseEntity<Invoice> createInvoice(@RequestBody BookingDto bookingDto) {

		Invoice invoice = invoiceService.createDraftInvoice(bookingDto);
		return new ResponseEntity<Invoice>(invoice, HttpStatus.CREATED);
	}
}
