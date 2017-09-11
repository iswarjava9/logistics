package com.suis.logistics.web.division;

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

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<DivisionDto> get(@PathVariable("id") int id) {

		DivisionDto division = converterUtil.convertDivisionToDto(divisionService.getDivision(id));
		return new ResponseEntity<DivisionDto>(division, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "byname/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<DivisionDto>> getAllDivisionsByName(@PathVariable("name") String name) {
		List<DivisionDto> divisions = converterUtil.convertDivisionListToDto(divisionService.getDivisionsByName(name));
		return new ResponseEntity<List<DivisionDto>>(divisions, HttpStatus.OK);
	}
}
