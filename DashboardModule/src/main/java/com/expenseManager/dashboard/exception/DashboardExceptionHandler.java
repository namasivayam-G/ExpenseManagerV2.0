package com.expenseManager.dashboard.exception;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.expenseManager.dashboard.models.Response;


@RestControllerAdvice
public class DashboardExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public final ResponseEntity<String> handleUnCheckedException(Exception ex) {
		return new ResponseEntity<String>("URL not found here", null);
	}
	
	@ExceptionHandler(DashboardException.class)
	@ResponseBody
	public final Response handleDashboardException(DashboardException ex) {
		return new Response(ex.getResponse().getMessage());
	}
	
	/*@Override
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNoHandlerFoundException(
			NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		HashMap<String, String> response = new HashMap<>();
        response.put("status", "fail");
        response.put("message", ex.getLocalizedMessage());
		return handleExceptionInternal(ex, response, headers, status, request);
	}*/
	
}
