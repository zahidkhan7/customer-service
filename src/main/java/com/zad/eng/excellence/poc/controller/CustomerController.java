package com.zad.eng.excellence.poc.controller;

import com.zad.eng.excellence.poc.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zad.eng.excellence.poc.model.CustomerPayload;
import com.zad.eng.excellence.poc.service.CustomerResponseTransformer;

import com.zad.eng.excellence.poc.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    private final CustomerResponseTransformer responseTransformer;

    public CustomerController(CustomerResponseTransformer transformer) {

        this.responseTransformer = transformer;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<CustomerPayload>> getCustomerDefaultCustomer() {
        ApiResponse<CustomerPayload> customerPayload= responseTransformer.getCustomerById("465");
        return new ResponseEntity<>(customerPayload, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerPayload>> getCustomerById(
            @PathVariable String customerId) {
        ApiResponse<CustomerPayload> response = responseTransformer.getCustomerById(customerId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }


    }

    }
