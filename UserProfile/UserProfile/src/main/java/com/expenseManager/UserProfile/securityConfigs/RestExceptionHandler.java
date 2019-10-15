package com.expenseManager.UserProfile.securityConfigs;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.expenseManager.UserProfile.exception.UserNotfoundException;
import com.expenseManager.UserProfile.models.ApiError;
import com.expenseManager.UserProfile.models.User;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotfoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ApiError> handleUserNotFound(UserNotfoundException ex){
		System.out.println("Coming here,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		ApiError apiError = new ApiError("User Not found in System", Arrays.asList("Matter", "No matter"));
		ResponseEntity<ApiError> res = new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
		return res;
	}

}