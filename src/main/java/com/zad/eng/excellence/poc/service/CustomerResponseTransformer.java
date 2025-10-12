package com.zad.eng.excellence.poc.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.zad.eng.excellence.poc.dto.ApiFailureResponse;
import com.zad.eng.excellence.poc.dto.ApiSuccessResponse;
import com.zad.eng.excellence.poc.dto.Customer;
import com.zad.eng.excellence.poc.dto.ErrorDetail;
import com.zad.eng.excellence.poc.dto.Performance;
import com.zad.eng.excellence.poc.model.CustomerEntity;


@Component
public class CustomerResponseTransformer {


    public ApiSuccessResponse<?> buildApiSuccessResponse(CustomerEntity customerEntity) {
            return transformToApiResponse(customerEntity);      
    }
    
    public static ApiSuccessResponse<Customer> transformToApiResponse(CustomerEntity entity) {

        Customer customer = new Customer(
                entity.getCustomerId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDateOfBirth(),
                entity.getGender(),
                entity.getNationalId(),
                entity.getCustomerType(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );

        ApiSuccessResponse.Metadata metadata = new ApiSuccessResponse.Metadata(
                LocalDateTime.now(),
                "downstream-api"
        );

        Performance performance = new Performance();
        performance.setExecutionTimeMs(384);
        performance.setDownstreamCallTimeMs(null);
        performance.setTransformationTimeMs(null);
        performance.setAuthenticationTimeMs(null);
        performance.setRetryAttempts(0);
        performance.setCircuitBreakerState("CLOSED");
        performance.setCacheHit(null);
        performance.setQueueWaitTimeMs(null);

        // --- Step 4: Create ApiSuccessResponse (using your subclass constructor) ---
        ApiSuccessResponse<Customer> response = new ApiSuccessResponse<>(
                true,                              // success flag
                "SUCCESS",                         // status
                UUID.randomUUID().toString(),       // correlationId
                LocalDateTime.now(),                // timestamp
                "user-api",                         // serviceName
                "REST_JSON",                        // protocol
                performance                         // performance details
        );

        
        ApiSuccessResponse.Payload<Customer> payload =
                new ApiSuccessResponse.Payload<>(customer, metadata);
        response.setPayload(payload);

        return response;
    }


    public ApiFailureResponse<ErrorDetail> buildApiFailureResponse() {

        // --- Step 1: Create Performance metrics ---
        Performance performance = new Performance();
        performance.setExecutionTimeMs(32);
        performance.setDownstreamCallTimeMs(null);
        performance.setTransformationTimeMs(null);
        performance.setAuthenticationTimeMs(null);
        performance.setRetryAttempts(null);
        performance.setCircuitBreakerState(null);
        performance.setCacheHit(null);
        performance.setQueueWaitTimeMs(null);

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setErrorCode("HTTP_404");
        errorDetail.setErrorMessage("Not Found");
        errorDetail.setErrorDescription("");
        errorDetail.setCategory("TECHNICAL");
        errorDetail.setSeverity("HIGH");
        errorDetail.setSource(null);
        errorDetail.setTechnicalMessage(null);
        errorDetail.setExceptionClass(null);
        errorDetail.setBusinessRuleViolated(null);
        errorDetail.setValidationErrors(null);
        errorDetail.setRetryable(false);
        errorDetail.setRetryAfterSeconds(null);
        errorDetail.setDownstreamService("user-api");
        errorDetail.setHttpStatusCode(404);
        errorDetail.setOriginalErrorCode(null);
        errorDetail.setAdditionalContext(null);
        errorDetail.setResolutionSteps(null);
        errorDetail.setSupportReferenceId(null);

        // --- Step 3: Build failure response ---
        ApiFailureResponse<ErrorDetail> failureResponse = new ApiFailureResponse<>(
                false,                          // success = false
                "ERROR",                        // status
                UUID.randomUUID().toString(),   // correlationId
                LocalDateTime.now(),            // timestamp
                "user-api",                     // serviceName
                "REST_JSON",                    // protocol
                performance                   // performance metrics
        );

        failureResponse.setErrorDetail(errorDetail);
        return failureResponse;
    }
    
}
