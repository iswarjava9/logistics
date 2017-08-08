package com.suis.logistics.service.person;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Person;
import com.suis.logistics.repository.person.PersonDao;

@Component
public class PersonServiceImpl implements PersonService {

	@Resource
	PersonDao personDao;

	@Override
	public Integer addPerson(Person person) {
		return personDao.createPerson(person);
	}
}
