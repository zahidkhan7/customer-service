package com.zad.eng.excellence.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zad.eng.excellence.poc.model.CustomerEntity;
import com.zad.eng.excellence.poc.storage.CustomerDataStorageImpl;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDataStorageImpl customerDataStorage;

	public CustomerServiceImpl(CustomerDataStorageImpl customerDataStorage) {
		this.customerDataStorage = customerDataStorage;
	}

	public CustomerEntity getCustomerById(String customerId) {
		CustomerEntity customer = customerDataStorage.getCustomerById(customerId);
		return customer;
	}


	public List<CustomerEntity> getAllCustomers() {
		return customerDataStorage.getAllCustomers();
	}
}
