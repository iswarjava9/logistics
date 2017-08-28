package com.suis.logistics.web.customer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDto> get(@PathVariable("id") int id) {

		CustomerDto customerDto = converterUtil.convertCustomerToDto(customerService.getCustomer(id));
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {
		List<CustomerDto> customers = converterUtil.convertCustomerListToDto(customerService.getAllCustomers());
		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "byname/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDto>> getCustomersByName(@PathVariable("name") String name) {
		List<CustomerDto> customers = converterUtil.convertCustomerListToDto(customerService.getCustomersByName(name));
		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}

}
