package com.expenseManager.UserProfile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseManager.UserProfile.exception.UserNotfoundException;
import com.expenseManager.UserProfile.models.User;
import com.expenseManager.UserProfile.services.ProfileService;

@RestController
@RequestMapping("/myprofile")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@GetMapping("/view/{userName}")
	public ResponseEntity<Object> getUserProfile(@PathVariable("userName") String UserName) throws UserNotfoundException {
		ResponseEntity<Object> res =  profileService.getUserProfile(UserName);
		return res;
	}
	
	@GetMapping("/view")	
	public String getUserProfiles() {
		return "oooooop";
	}
	
}
