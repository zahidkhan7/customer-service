package com.zad.eng.excellence.poc.storage;

import com.zad.eng.excellence.poc.model.CustomerPayload;

import com.zad.eng.excellence.poc.model.CustomerPayload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataStorageImpl implements CustomerDataStorage {

    @Override
    public CustomerPayload getDefaultCustomerPayload() {
        // Prepare customer data
        CustomerPayload.Customer customer = new CustomerPayload.Customer();
        customer.setCustomerId("5f46f1d9-bd5a-4a18-a949-a6b156533400");
        customer.setFirstName("TechCorp");
        customer.setLastName("Ltd");
        customer.setDateOfBirth(null); // optional
        customer.setGender("MALE");
        customer.setNationalId("REG-99887766");
        customer.setCustomerType("BUSINESS");
        customer.setStatus("ACTIVE");
        customer.setCreatedAt(LocalDateTime.parse("2025-03-13T08:19:35.3519403"));
        customer.setUpdatedAt(LocalDateTime.parse("2025-09-29T08:19:35.3519403"));

        // Prepare metadata
        CustomerPayload.Metadata metadata = new CustomerPayload.Metadata();
        metadata.setRetrievedAt(LocalDateTime.now());
        metadata.setSource("crm-system");

        // Wrap into payload
        CustomerPayload payload = new CustomerPayload();
        payload.setCustomer(customer);
        payload.setMetadata(metadata);

        return payload;
    }
}
