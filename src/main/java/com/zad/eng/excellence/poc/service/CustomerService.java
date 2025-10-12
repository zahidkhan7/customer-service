package com.zad.eng.excellence.poc.service;

import java.util.List;

import com.zad.eng.excellence.poc.dto.ApiSuccessResponse;
import com.zad.eng.excellence.poc.model.CustomerEntity;

public interface CustomerService {

    /**
     * Fetch a customer by their unique ID.
     * @param customerId the ID of the customer
     * @return the CustomerEntity object
     * @throws java.util.NoSuchElementException if customer is not found
     */
		CustomerEntity  getCustomerById(String customerId);

    /**
     * Fetch all customers in the system.
     * @return list of CustomerEntity objects
     */
    List<CustomerEntity> getAllCustomers();
}
