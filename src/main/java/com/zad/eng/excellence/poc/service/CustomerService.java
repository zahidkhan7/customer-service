package com.zad.eng.excellence.poc.service;

import com.zad.eng.excellence.poc.model.CustomerPayload;

public interface CustomerService {

    public CustomerPayload getCustomerById(String customerId);
}
