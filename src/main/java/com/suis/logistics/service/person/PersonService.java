package com.suis.logistics.service.person;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Person;

@Transactional
public interface PersonService {

	public Integer addPerson(Person person);
}
