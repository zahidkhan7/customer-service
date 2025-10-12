package com.zad.eng.excellence.poc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zad.eng.excellence.poc.dto.ApiResponse;
import com.zad.eng.excellence.poc.service.CustomerFacadeService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerFacadeService custFacadeService;

	public CustomerController(CustomerFacadeService facadeService) {

		this.custFacadeService = facadeService;
	}

	/*
	@GetMapping
	public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
		List<CustomerEntity> customersPayload = custFacadeService.getAllCustomers();
		return new ResponseEntity<>(customersPayload, HttpStatus.OK);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable String customerId) {
		CustomerEntity customerPayload = custFacadeService.getCustomerById(customerId);
		if(customerPayload !=null) {
			return new ResponseEntity<>(customerPayload, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new CustomerEntity(), HttpStatus.NOT_FOUND);
		}
	}
	
	*/
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") String customerId) {
		ApiResponse apiResponse = custFacadeService.getCustomerById(customerId);
		if(apiResponse.getApiSuccessResponse()!=null) {
			return new ResponseEntity<>(apiResponse.getApiSuccessResponse(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(apiResponse.getApiFailureResponse(), HttpStatus.NOT_FOUND);
		}
	    
	}

}
