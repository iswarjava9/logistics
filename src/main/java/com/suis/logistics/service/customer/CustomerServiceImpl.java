package com.suis.logistics.service.customer;

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

}
