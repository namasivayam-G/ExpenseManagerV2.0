package com.ExpenseManager.SummationHandler.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest.Headers;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
	
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/see")
public class SummationController {
	
	@Autowired
	RestTemplate rt;
	
	private  final String expense_url ="http://GENERIC-EXPENSE-MANAGER-MODULE/expense/total-expenses/{userId}";
	//Headers headers = new HttpHeaders();
	//headers.set("Accept", "application/json");
	 
	@GetMapping("/users")
	public ResponseEntity<String> getUsers(){
		System.out.println("0000000000000000000000000000000000000");
		ResponseEntity<String> res = rt.getForEntity("http://USERPROFILE/myprofile/view", String.class);
		return res;
		
	}
	
	@HystrixCommand(fallbackMethod ="defaultUserList")
	@GetMapping("/expenses/{userId}")
	public ResponseEntity<List> getExpensesByUser(@PathVariable("userId") String userId){
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(expense_url).build();
		Map<String, String> uriParam = new HashMap<>();
	    uriParam.put("userId", userId);				
		 HttpEntity<?> httpEntity  = new HttpEntity<>(null); 
		ResponseEntity<List> res = rt.exchange(builder.toUriString(),HttpMethod.GET, httpEntity,List.class, uriParam);
		//ResponseEntity<List> res = rt.getForEntity("http://GENERIC-EXPENSE-MANAGER-MODULE/expense/total-expenses/{userId}", List.class, userId);
		return res;
		
	}
	
	public ResponseEntity<List> defaultUserList(@PathVariable("userId") String userId){
		List ls = new ArrayList<>();
		ls.add("Ithellam ilae da sunni");
		ResponseEntity<List> res = new ResponseEntity<List>(ls, HttpStatus.REQUEST_TIMEOUT);
		return res;
	}

}
