package com.suis.logistics.web.customer;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.customer.CustomerService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {

	@Resource
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> registerClient(@RequestBody CustomerDto customerDto) {

		Integer customerId = customerService.addCustomer(converterUtil.convertCustomerDtoToEntity(customerDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("customerId", String.valueOf(customerId));

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

}
