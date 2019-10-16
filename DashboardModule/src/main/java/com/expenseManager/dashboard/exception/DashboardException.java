package com.expenseManager.dashboard.exception;

import com.expenseManager.dashboard.models.Response;

public class DashboardException extends RuntimeException {
	
	private Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public DashboardException(Response response) {
		super();
		this.response = response;
	}

	

}
