package com.suis.logistics.repository.person;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Person;
import com.suis.logistics.repository.BaseDao;

@Repository
public class PersonDaoImpl extends BaseDao implements PersonDao {

	@Override
	public Integer createPerson(Person person) {
		getCurrentSession().save(person);
		return person.getId();
	}

	@Override
	public Person findById(int id) {
		return getCurrentSession().load(Person.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersonsByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Person.findByName").setParameter("name", name + "%");
		List<Person> personList = query.list();
		return personList;
	}
}
