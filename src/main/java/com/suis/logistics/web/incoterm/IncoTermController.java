package com.suis.logistics.web.incoterm;

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

import com.suis.logistics.service.incoterm.IncoTermService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/incoterm")
public class IncoTermController extends BaseController {

	@Resource
	IncoTermService incoTermService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createContainerType(@RequestBody IncoTermDto incoTermDto) {
		Integer incoTermId = incoTermService.createIncoTerm(converterUtil.convertIncoTermDtoToEntity(incoTermDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("incoTermId", String.valueOf(incoTermId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<IncoTermDto> get(@PathVariable("id") int id) {
		IncoTermDto incoTermDto = converterUtil.convertIncoTermToDto(incoTermService.getIncoTerm(id));
		return new ResponseEntity<IncoTermDto>(incoTermDto, HttpStatus.OK);
	}
}
