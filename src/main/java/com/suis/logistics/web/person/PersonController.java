package com.suis.logistics.web.person;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.person.PersonService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

	@Resource
	PersonService personService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addPerson(@RequestBody PersonDto personDto) {
		Integer personId = personService.addPerson(converterUtil.convertPersonDtoToEntity(personDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("personId", String.valueOf(personId));

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
