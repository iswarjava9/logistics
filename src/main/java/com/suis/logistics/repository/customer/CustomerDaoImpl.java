package com.suis.logistics.repository.customer;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Customer;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
	@Autowired
	Environment env;

	@Override
	public Customer createCustomer(Customer customer) {
		try {
			getCurrentSession().save(customer);
		} catch (Exception e) {
			throw new AddCustomerFailedException(e, env);
		}
		clearCache("customerByName");
		return customer;
	}

	@Override
	public Customer findById(int id) {
		return getCurrentSession().load(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		Query query = getCurrentSession().getNamedQuery("Customer.findAll");
		List<Customer> customerList = query.list();
		return customerList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value = "customerByName", key = "#name")
	public List<Customer> getCustomersByName(String name) {

		Query query = getCurrentSession().getNamedQuery("Customer.findByName").setParameter("name", name + "%");
		List<Customer> customers = query.list();
		return customers;
	}

	@Override
	public void updateCustomer(Customer customer) {
		getCurrentSession().update(customer);
	}
}
