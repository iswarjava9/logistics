package com.suis.logistics.repository.customer;

import java.util.List;

import com.suis.logistics.model.Customer;

public interface CustomerDao {

	public Customer createCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer findById(int id);

	public List<Customer> getAllCustomers();

	public List<Customer> getCustomersByName(String name);
}
