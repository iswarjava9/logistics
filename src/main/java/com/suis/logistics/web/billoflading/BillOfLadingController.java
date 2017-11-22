package com.suis.logistics.web.billoflading;

import java.io.InputStream;

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
import com.suis.logistics.service.billoflading.BillOfLadingService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/billoflading")
public class BillOfLadingController extends BaseController {
	@Resource
	BillOfLadingService	billOfLadingService;
	@Resource
	PDFGeneratorUtil	pdfGeneratorUtil;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BillOfLadingDto> createBillOfLading(@RequestBody BillOfLadingDto billOfLadingDto) {

		BillOfLadingDto billOfLadingDtoResponse = converterUtil.convertBillOfLadingToDto(
				billOfLadingService.createBillOfLading(converterUtil.convertBillOfLadingDtoToEntity(billOfLadingDto)));
		return new ResponseEntity<BillOfLadingDto>(billOfLadingDtoResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BillOfLadingDto> updateBillOfLading(@RequestBody BillOfLadingDto billOfLadingDto) {

		BillOfLadingDto billOfLadingDtoResponse = converterUtil.convertBillOfLadingToDto(
				billOfLadingService.updateBillOfLading(converterUtil.convertBillOfLadingDtoToEntity(billOfLadingDto)));
		return new ResponseEntity<BillOfLadingDto>(billOfLadingDtoResponse, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<BillOfLadingDto> get(@PathVariable("id") int id) {

		BillOfLadingDto billOfLadingDto = converterUtil
				.convertBillOfLadingToDto(billOfLadingService.getBillOfLading(id));
		return new ResponseEntity<BillOfLadingDto>(billOfLadingDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> download(@PathVariable("id") int id) throws Exception {
		BillOfLadingDto billOfLadingDto = converterUtil
				.convertBillOfLadingToDto(billOfLadingService.getBillOfLading(id));
		pdfGeneratorUtil.generateBillOfLadingPDF(billOfLadingDto);
		HttpHeaders headers = new HttpHeaders();
		InputStream bookingConfirmationPDF = billOfLadingService.downloadBillOfLading(billOfLadingDto.getBlNo(),
				headers);
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(bookingConfirmationPDF), headers, HttpStatus.OK);
		return response;
	}
}
