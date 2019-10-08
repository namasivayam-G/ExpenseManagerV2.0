package com.expenseManager.UserProfile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotfoundException extends Exception {

	private static final long serialVersionUID = 101;

	public UserNotfoundException(String s){
		super(s);
	}
}
