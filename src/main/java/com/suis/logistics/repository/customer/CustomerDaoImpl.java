package com.suis.logistics.repository.customer;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Customer;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	@Override
	public Integer createCustomer(Customer customer) {
		getCurrentSession().save(customer);
		return customer.getId();

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

	@Override
	public List<Customer> getCustomersByName(String name) {
		Query query = getCurrentSession().getNamedQuery("Customer.findByName").setParameter("name", name+"%");
		List<Customer> customers = query.list();
		return customers;
	}



}
