package com.zad.eng.excellence.poc.service;

import java.util.List;

import com.zad.eng.excellence.poc.dto.ApiResponse;
import com.zad.eng.excellence.poc.model.CustomerEntity;

public interface CustomerFacadeService {

	/**
     * Fetch a single customer by their unique ID.
     * @param customerId the ID of the customer
     * @return CustomerEntity object
     */
	ApiResponse  getCustomerById(String customerId);

    /**
     * Fetch all customers.
     * @return List of CustomerEntity objects
     */
    List<CustomerEntity> getAllCustomers();
}
