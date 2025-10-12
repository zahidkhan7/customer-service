package com.zad.eng.excellence.poc.dto;

public class CustomerPayload {
	private Customer customer;

	private Metadata metadata;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

}
