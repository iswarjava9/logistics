package com.suis.logistics.web.division;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.division.DivisionService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/division")
public class DivisionController extends BaseController {

	@Resource
	DivisionService divisionService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addDivision(@RequestBody DivisionDto divisionDto) {

		Integer divisionId = divisionService.addDivision(converterUtil.convertDivisionDtoToEntity(divisionDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("divisionId", String.valueOf(divisionId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
