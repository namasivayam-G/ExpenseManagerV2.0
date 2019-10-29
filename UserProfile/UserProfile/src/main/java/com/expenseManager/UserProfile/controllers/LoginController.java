package com.expenseManager.UserProfile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenseManager.UserProfile.exception.UserCustomException;
import com.expenseManager.UserProfile.models.Response;
import com.expenseManager.UserProfile.models.User;
import com.expenseManager.UserProfile.services.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/register-user")
	public Response registerUserProfile(@RequestBody User user) throws UserCustomException{
		return loginService.registerUserProfile(user);
	}
	
	
	@GetMapping("/login/{userName}/{password}")
	public Response loginUser(@PathVariable("userName") String userName,@PathVariable("password") String password) throws UserCustomException{
		return loginService.loginUser(userName,password);
	}
	
}
