package com.suis.logistics.web.booking;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.booking.BookingService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController {
	@Resource
	BookingService bookingService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createBooking(@RequestBody BookingDto bookingDto) {

		Integer bookingId = bookingService.createBooking(converterUtil.convertBookingDtoToEntity(bookingDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("bookingId", String.valueOf(bookingId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<BookingDto> get(@PathVariable("id") int id) {

		BookingDto bookingDto = converterUtil.convertBookingDetailToDto(bookingService.getBookingDetail(id));
		return new ResponseEntity<BookingDto>(bookingDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<BookingDto>> getBookingList() {
		List<BookingDto> bookings = converterUtil.convertBookingDetailToDtoList(bookingService.getBookingList());
		return new ResponseEntity<List<BookingDto>>(bookings, HttpStatus.OK);
	}

}
