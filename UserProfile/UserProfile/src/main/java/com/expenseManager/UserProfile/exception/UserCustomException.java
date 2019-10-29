package com.expenseManager.UserProfile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.expenseManager.UserProfile.models.Response;

public class UserCustomException extends Exception {

	public UserCustomException(Response response) {
		super();
		this.response = response;
	}

	private static final long serialVersionUID = 101;

	private Response response;
	
	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}