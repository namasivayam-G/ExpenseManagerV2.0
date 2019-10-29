package com.expenseManager.UserProfile.exception;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.expenseManager.UserProfile.models.Response;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserCustomException.class)
	@ResponseBody
	public final Response handleUserCustomException(UserCustomException ex) {
		return new Response(ex.getResponse().getMessage());
	}

}
