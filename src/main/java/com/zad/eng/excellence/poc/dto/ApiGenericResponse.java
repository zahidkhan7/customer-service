package com.zad.eng.excellence.poc.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiGenericResponse {

	private boolean success = true;
	private String status;
	private String correlationId;
	private LocalDateTime timestamp;
	private String serviceName;
	private String protocol = "REST_JSON";
	private Performance performance;
	
	public ApiGenericResponse(boolean success, String status, String correlationId, LocalDateTime timestamp,
			String serviceName, String protocol, Performance performance) {
		super();
		this.success = success;
		this.status = status;
		this.correlationId = correlationId;
		this.timestamp = timestamp;
		this.serviceName = serviceName;
		this.protocol = protocol;
		this.performance = performance;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}


}
