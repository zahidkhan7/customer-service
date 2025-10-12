package com.zad.eng.excellence.poc.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.zad.eng.excellence.poc.dto.ApiResponse;
import com.zad.eng.excellence.poc.model.CustomerEntity;

@Service
public class CustomerFacadeServiceImpl implements CustomerFacadeService {

	private final CustomerResponseTransformer customerTransformer;

	private final CustomerService customerService;

	public CustomerFacadeServiceImpl(CustomerService service, CustomerResponseTransformer transformerService) {
		this.customerTransformer = transformerService;
		this.customerService = service;
	}

	@Override
	public ApiResponse getCustomerById(String customerId) {
		CustomerEntity customerEntity = customerService.getCustomerById(customerId);
		ApiResponse apiResponse = new ApiResponse();
		  if(Objects.nonNull(customerEntity) ){
			  apiResponse.setApiSuccessResponse( customerTransformer.buildApiSuccessResponse(customerEntity));
			  return apiResponse;
		  }		
		  apiResponse.setApiFailureResponse( customerTransformer.buildApiFailureResponse());
		 return apiResponse;
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> customerEntities = customerService.getAllCustomers();
		return customerEntities;
	}

}
