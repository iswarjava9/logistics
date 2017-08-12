package com.suis.logistics.web.quotation;

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

import com.suis.logistics.service.quotation.QuotationService;
import com.suis.logistics.web.BaseController;


@RestController
@RequestMapping("/quotation")
public class QuotationController extends BaseController {

	@Resource
	QuotationService quotationService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createBooking(@RequestBody QuotationDto quotationDto) {

		Integer quotationId = quotationService.createQuotation(converterUtil.convertQuotationDtoToEntity(quotationDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("bookingId", String.valueOf(quotationId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<QuotationDto> get(@PathVariable("id") int id) {

		QuotationDto quotationDto = converterUtil.convertQuotationToDto(quotationService.getQuotation(id));
		return new ResponseEntity<QuotationDto>(quotationDto, HttpStatus.OK);
	}

}
