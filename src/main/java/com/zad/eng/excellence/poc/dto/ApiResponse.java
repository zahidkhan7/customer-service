package com.zad.eng.excellence.poc.dto;

public class ApiResponse {

	private ApiSuccessResponse<?> apiSuccessResponse;

	private ApiFailureResponse<?> apiFailureResponse;

	public ApiSuccessResponse<?> getApiSuccessResponse() {
		return apiSuccessResponse;
	}

	public void setApiSuccessResponse(ApiSuccessResponse<?> apiSuccessResponse) {
		this.apiSuccessResponse = apiSuccessResponse;
	}

	public ApiFailureResponse<?> getApiFailureResponse() {
		return apiFailureResponse;
	}

	public void setApiFailureResponse(ApiFailureResponse<?> apiFailureResponse) {
		this.apiFailureResponse = apiFailureResponse;
	}

}
