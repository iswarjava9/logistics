package com.suis.logistics.service.customer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Customer;
import com.suis.logistics.repository.customer.CustomerDao;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Resource
	CustomerDao customerDao;

	@Override
	public Integer addCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public List<Customer> getCustomersByName(String name) {
		return customerDao.getCustomersByName(name);
	}

}
