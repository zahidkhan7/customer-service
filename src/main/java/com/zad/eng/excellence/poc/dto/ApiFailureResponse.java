package com.zad.eng.excellence.poc.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiFailureResponse<T>  extends ApiGenericResponse {

	public ApiFailureResponse(boolean success, String status, String correlationId, LocalDateTime timestamp,
			String serviceName, String protocol, Performance performance) {
		super(success, status, correlationId, timestamp, serviceName, protocol, performance);
		
	}
	
	private ErrorDetail errorDetail;

	public ErrorDetail getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(ErrorDetail errorDetail) {
		this.errorDetail = errorDetail;
	}

}
