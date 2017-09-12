package com.suis.logistics.web.booking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController {
	@Resource
	BookingService	bookingService;
	@Autowired
	ServletContext	context;
	@Resource
	PDFGeneratorUtil pdfGeneratorUtil;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {

		BookingDto bookingDtoResponse = converterUtil.convertBookingDetailToDto(
				bookingService.createBooking(converterUtil.convertBookingDtoToEntity(bookingDto)));
		String remarks = bookingDtoResponse.getRemarks();
		if(remarks != null) {
			bookingDtoResponse.setRemarks(remarks.replace("\\n", "\n"));
		}
		return new ResponseEntity<BookingDto>(bookingDtoResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto) {

		BookingDto bookingDtoResponse = converterUtil.convertBookingDetailToDto(
				bookingService.updateBooking(converterUtil.convertBookingDtoToEntity(bookingDto)));
		String remarks = bookingDtoResponse.getRemarks();
		if(remarks != null) {
			bookingDtoResponse.setRemarks(remarks.replace("\\n", "\n"));
		}
		return new ResponseEntity<BookingDto>(bookingDtoResponse, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<BookingDto> get(@PathVariable("id") int id) {

		BookingDto bookingDto = converterUtil.convertBookingDetailToDto(bookingService.getBookingDetail(id));
		String remarks = bookingDto.getRemarks();
		if(remarks != null) {
			bookingDto.setRemarks(remarks.replace("\\n", "\n"));
		}
		//generateBookingXml(bookingDto);
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
	public ResponseEntity<InputStreamResource> download(@PathVariable("id") int id)
			throws Exception {
		BookingDto bookingDto = converterUtil.convertBookingDetailToDto(bookingService.getBookingDetail(id));
		pdfGeneratorUtil.generateBookingConfirmationPDF(bookingDto);
		HttpHeaders headers = new HttpHeaders();
		InputStream bookingConfirmationPDF = bookingService.downloadBookingConfirmation(bookingDto.getForwarderRefNo(), headers);
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(bookingConfirmationPDF), headers, HttpStatus.OK);
		return response;
	}

	private void generateBookingXml(BookingDto bookingDto) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(BookingDto.class);
			JAXBElement<BookingDto> jaxbElement = new JAXBElement<BookingDto>(new QName("bookinginfo"),
					BookingDto.class, bookingDto);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// URL url = this.getClass().getResource("/resources");
			// File xmlDataFile = new
			// File(url.toURI().getPath()+"booking-"+bookingDto.getId()+".xml");
			File xmlDataFile = new File(
					"C://My Drive//WORKSPACEs//Logistics//logistics//src//main//resources//xml-data//booking-"+bookingDto.getForwarderRefNo()+".xml");
			xmlDataFile.createNewFile(); // if file already exists will do
											// nothing
			OutputStream out = new FileOutputStream(xmlDataFile);
			marshaller.marshal(jaxbElement, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
