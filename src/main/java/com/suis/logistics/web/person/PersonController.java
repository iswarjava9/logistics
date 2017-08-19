package com.suis.logistics.web.person;

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

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<PersonDto> get(@PathVariable("id") int id) {

		PersonDto person = converterUtil.convertPersonToDto(personService.getPerson(id));
		return new ResponseEntity<PersonDto>(person, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<PersonDto>> getAllPersons() {
		List<PersonDto> persons = converterUtil.convertPersonListToDto(personService.getAllPersons());
		return new ResponseEntity<List<PersonDto>>(persons, HttpStatus.OK);
	}
}
