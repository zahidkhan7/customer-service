package com.zad.eng.excellence.poc.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiSuccessResponse<T> extends ApiGenericResponse {
	
	public ApiSuccessResponse(boolean success, String status, String correlationId, LocalDateTime timestamp,
			String serviceName, String protocol, com.zad.eng.excellence.poc.dto.Performance performance) {
		super(success, status, correlationId, timestamp, serviceName, protocol, performance);
		
	}

	private Payload<T> payload;
	
	
	// Nested classes
	public static class Payload<T> {
		private T customer;
		private Metadata metadata;

		public Payload(T customer, Metadata metadata) {
			this.customer = customer;
			this.metadata = metadata;
		}

		public T getCustomer() {
			return customer;
		}

		public Metadata getMetadata() {
			return metadata;
		}
	}

	public static class Metadata {
		private LocalDateTime retrievedAt;
		private String source;

		public Metadata(LocalDateTime retrievedAt, String source) {
			this.retrievedAt = retrievedAt;
			this.source = source;
		}

		public LocalDateTime getRetrievedAt() {
			return retrievedAt;
		}

		public String getSource() {
			return source;
		}
	}

	public static class Performance {
		private long executionTimeMs;
		private Long downstreamCallTimeMs;
		private Long transformationTimeMs;
		private Long authenticationTimeMs;
		private Integer retryAttempts;
		private String circuitBreakerState;
		private Boolean cacheHit;
		private Long queueWaitTimeMs;

		public Performance(long executionTimeMs) {
			this.executionTimeMs = executionTimeMs;
			this.circuitBreakerState = "CLOSED";
		}

		public Performance() {
			
		}

		public long getExecutionTimeMs() {
			return executionTimeMs;
		}

		public Long getDownstreamCallTimeMs() {
			return downstreamCallTimeMs;
		}

		public void setDownstreamCallTimeMs(Long downstreamCallTimeMs) {
			this.downstreamCallTimeMs = downstreamCallTimeMs;
		}

		public Long getTransformationTimeMs() {
			return transformationTimeMs;
		}

		public void setTransformationTimeMs(Long transformationTimeMs) {
			this.transformationTimeMs = transformationTimeMs;
		}

		public Long getAuthenticationTimeMs() {
			return authenticationTimeMs;
		}

		public void setAuthenticationTimeMs(Long authenticationTimeMs) {
			this.authenticationTimeMs = authenticationTimeMs;
		}

		public Integer getRetryAttempts() {
			return retryAttempts;
		}

		public void setRetryAttempts(Integer retryAttempts) {
			this.retryAttempts = retryAttempts;
		}

		public String getCircuitBreakerState() {
			return circuitBreakerState;
		}

		public void setCircuitBreakerState(String circuitBreakerState) {
			this.circuitBreakerState = circuitBreakerState;
		}

		public Boolean getCacheHit() {
			return cacheHit;
		}

		public void setCacheHit(Boolean cacheHit) {
			this.cacheHit = cacheHit;
		}

		public Long getQueueWaitTimeMs() {
			return queueWaitTimeMs;
		}

		public void setQueueWaitTimeMs(Long queueWaitTimeMs) {
			this.queueWaitTimeMs = queueWaitTimeMs;
		}

		public void setExecutionTimeMs(long executionTimeMs) {
			this.executionTimeMs = executionTimeMs;
		}
	}


	public Payload<T> getPayload() {
		return payload;
	}


	public void setPayload(Payload<T> payload) {
		this.payload = payload;
	}


	


}
