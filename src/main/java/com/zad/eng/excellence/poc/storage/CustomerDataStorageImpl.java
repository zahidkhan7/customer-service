package com.zad.eng.excellence.poc.storage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.zad.eng.excellence.poc.model.CustomerEntity;

@Component
public class CustomerDataStorageImpl {

	private final Map<String, CustomerEntity> customerMap = new ConcurrentHashMap<>();

	// Add a new customer
	public void addCustomer(CustomerEntity customer) {
		if (customer == null || customer.getCustomerId() == null) {
			throw new IllegalArgumentException("Customer or customerId cannot be null");
		}
		customerMap.put(customer.getCustomerId(), customer);
	}

	// Get customer by ID
	public CustomerEntity getCustomerById(String customerId) {
		return customerMap.get(customerId);
	}

	// Update existing customer
	public void updateCustomer(CustomerEntity customer) {
		if (customer == null || customer.getCustomerId() == null) {
			throw new IllegalArgumentException("Customer or customerId cannot be null");
		}
		if (!customerMap.containsKey(customer.getCustomerId())) {
			throw new NoSuchElementException("Customer with ID " + customer.getCustomerId() + " not found");
		}
		customerMap.put(customer.getCustomerId(), customer);
	}

	// Delete customer by ID
	public void deleteCustomer(String customerId) {
		if (!customerMap.containsKey(customerId)) {
			throw new NoSuchElementException("Customer with ID " + customerId + " not found");
		}
		customerMap.remove(customerId);
	}

	// Get all customers
	public List<CustomerEntity> getAllCustomers() {
		return new ArrayList<>(customerMap.values());
	}

	// Check if customer exists
	public boolean exists(String customerId) {
		return customerMap.containsKey(customerId);
	}

	// Load some default dummy data
	public void loadDefaultCustomerData() {
		CustomerEntity customer1 = new CustomerEntity("cust001", "John", "Doe", LocalDateTime.of(1990, 5, 20, 0, 0),
				"Male", "NID123456", "Regular", "Active", LocalDateTime.now(), LocalDateTime.now());

		CustomerEntity customer2 = new CustomerEntity("cust002", "Jane", "Smith", LocalDateTime.of(1985, 8, 15, 0, 0),
				"Female", "NID789012", "Premium", "Active", LocalDateTime.now(), LocalDateTime.now());

		CustomerEntity customer3 = new CustomerEntity("cust003", "Alice", "Johnson",
				LocalDateTime.of(2000, 1, 10, 0, 0), "Female", "NID345678", "Regular", "Inactive", LocalDateTime.now(),
				LocalDateTime.now());

		addCustomer(customer1);
		addCustomer(customer2);
		addCustomer(customer3);
	}

	// Call loadDefaultCustomerData automatically after bean creation
	@PostConstruct
	public void init() {
		loadDefaultCustomerData();
	}
}
