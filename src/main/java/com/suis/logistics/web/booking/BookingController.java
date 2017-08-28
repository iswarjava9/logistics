package com.suis.logistics.web.booking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

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
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {

		BookingDto bookingDtoResponse = converterUtil.convertBookingDetailToDto(bookingService.createBooking(converterUtil.convertBookingDtoToEntity(bookingDto)));
		return new ResponseEntity<BookingDto>(bookingDtoResponse, HttpStatus.OK);
		/*HttpHeaders headers = new HttpHeaders();
		headers.set("bookingId", String.valueOf(bookingId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);*/
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<BookingDto> get(@PathVariable("id") int id) {

		BookingDto bookingDto = converterUtil.convertBookingDetailToDto(bookingService.getBookingDetail(id));
		generateBookingXml(bookingDto);
		return new ResponseEntity<BookingDto>(bookingDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<BookingDto>> getBookingList() {
		List<BookingDto> bookings = converterUtil.convertBookingDetailToDtoList(bookingService.getBookingList());
		return new ResponseEntity<List<BookingDto>>(bookings, HttpStatus.OK);
	}

	private void generateBookingXml(BookingDto bookingDto) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(BookingDto.class);
			JAXBElement<BookingDto> jaxbElement = new JAXBElement<BookingDto>(new QName("bookinginfo"), BookingDto.class,
					bookingDto);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//URL url = this.getClass().getResource("/resources");



				//	File xmlDataFile = new File(url.toURI().getPath()+"booking-"+bookingDto.getId()+".xml");

			File xmlDataFile = new File("C://My Drive//WORKSPACEs//Logistics//logistics//src//main//resources//xml-data//booking-dto1.xml");
			xmlDataFile.createNewFile(); // if file already exists will do nothing

			OutputStream out = new FileOutputStream(xmlDataFile);

			marshaller.marshal(jaxbElement, out);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
