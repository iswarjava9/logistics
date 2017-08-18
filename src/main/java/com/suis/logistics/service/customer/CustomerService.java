package com.suis.logistics.service.customer;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Customer;

@Transactional
public interface CustomerService {
	public Integer addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomers();
}
