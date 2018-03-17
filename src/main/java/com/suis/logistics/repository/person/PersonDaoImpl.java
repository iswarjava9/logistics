package com.suis.logistics.repository.person;

import java.util.List;

import org.hibernate.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Person;
import com.suis.logistics.repository.BaseDao;

@Repository
public class PersonDaoImpl extends BaseDao implements PersonDao {

	@Override
	public Integer createPerson(Person person) {
		getCurrentSession().save(person);
		clearCache("personByName");
		return person.getId();
	}

	@Override
	public Person findById(int id) {
		Person person;
		try {
			person = getCurrentSession().load(Person.class, id);
			person.getId();
		} catch (Exception e) {			
			throw new PersonNotFoundException(e);
		}
		return person;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value = "personByName", key = "#name")
	public List<Person> getPersonsByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Person.findByName").setParameter("name", name + "%");
		List<Person> personList = query.list();
		return personList;
	}
}
