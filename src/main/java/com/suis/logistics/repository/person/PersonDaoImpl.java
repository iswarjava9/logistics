package com.suis.logistics.repository.person;

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

}
