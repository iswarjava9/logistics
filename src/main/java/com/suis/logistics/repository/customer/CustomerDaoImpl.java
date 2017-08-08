package com.suis.logistics.repository.customer;

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
	
}
