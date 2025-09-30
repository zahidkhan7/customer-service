package com.zad.eng.excellence.poc.service;

import com.zad.eng.excellence.poc.model.CustomerPayload;
import com.zad.eng.excellence.poc.storage.CustomerDataStorageImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDataStorageImpl customerDataStorage;

    public CustomerServiceImpl(CustomerDataStorageImpl dataStorageImpl) {
        customerDataStorage = dataStorageImpl;
    }



    @Override
    public CustomerPayload getCustomerById(String customerId) {
        return customerDataStorage.getDefaultCustomerPayload();
    }
}
