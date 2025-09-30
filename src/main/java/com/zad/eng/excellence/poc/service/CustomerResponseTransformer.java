package com.zad.eng.excellence.poc.service;

import com.zad.eng.excellence.poc.service.CustomerServiceImpl;
import com.zad.eng.excellence.poc.model.CustomerPayload;
import com.zad.eng.excellence.poc.model.ApiResponse;
import com.zad.eng.excellence.poc.model.Performance;
import com.zad.eng.excellence.poc.model.ErrorDetail;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class CustomerResponseTransformer {

    private CustomerServiceImpl custService;

    // Constructor
    public CustomerResponseTransformer(CustomerServiceImpl service) {
        this.custService = service;
    }

    public ApiResponse<CustomerPayload> getCustomerById(String customerId) {
        if(Integer.parseInt(customerId) > 300){
            return transformToApiResponse(custService.getCustomerById(customerId));
        }
        else {
            return buildApiErrorResponse();
        }
    }

    private ApiResponse<CustomerPayload> buildApiErrorResponse() {
        ErrorDetail error = new ErrorDetail();
        error.setErrorCode("HTTP_404");
        error.setErrorMessage("Not Found");
        error.setCategory("TECHNICAL");
        error.setSeverity("HIGH");
        error.setHttpStatusCode(404);
        error.setRetryable(false);
        error.setDownstreamService("user-api");

        Performance perf = new Performance();
        perf.setExecutionTimeMs(26);

        ApiResponse<CustomerPayload> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setStatus("ERROR");
        response.setError(error);
        response.setCorrelationId("adcb-a84da1f9");
        response.setTimestamp(LocalDateTime.now());
        response.setServiceName("user-api");
        response.setProtocol("REST_JSON");
        response.setPerformance(perf);

        return response;
    }

    public ApiResponse<CustomerPayload> transformToApiResponse(CustomerPayload payload) {
        // --- Performance details (could be measured dynamically) ---
        Performance perf = new Performance();
        perf.setExecutionTimeMs(384);
        perf.setRetryAttempts(0);
        perf.setCircuitBreakerState("CLOSED");

        // --- Wrap into API Response ---
        ApiResponse<CustomerPayload> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setStatus("SUCCESS");
        response.setPayload(payload);
        response.setCorrelationId("adcb-dfe0e4dc"); // generate dynamically if needed
        response.setTimestamp(LocalDateTime.now());
        response.setServiceName("customer-api");
        response.setProtocol("REST_JSON");
        response.setPerformance(perf);

        return response;
    }


}
