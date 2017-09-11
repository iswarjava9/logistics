package com.suis.logistics.repository.person;

import java.util.List;

import com.suis.logistics.model.Person;

public interface PersonDao {

	public Integer createPerson(Person person);
	public Person findById(int id);
	public List<Person> getPersonsByName(String name);

}
