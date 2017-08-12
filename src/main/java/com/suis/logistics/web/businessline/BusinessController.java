package com.suis.logistics.web.businessline;

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

import com.suis.logistics.service.businessline.BusinessLineService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/businessline")
public class BusinessController extends BaseController {
	@Resource
	BusinessLineService businessLineService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createBooking(@RequestBody BusinessLineDto businessLineDto) {
		Integer businessLineId = businessLineService.createBusinessLine(converterUtil.convertBusinessLineDtoToEntity(businessLineDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("businessLineId", String.valueOf(businessLineId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<BusinessLineDto> get(@PathVariable("id") int id) {
		BusinessLineDto businessLineDto = converterUtil.convertBusinessLineToDto(businessLineService.getBusinessLine(id));
		return new ResponseEntity<BusinessLineDto>(businessLineDto, HttpStatus.OK);
	}
}
