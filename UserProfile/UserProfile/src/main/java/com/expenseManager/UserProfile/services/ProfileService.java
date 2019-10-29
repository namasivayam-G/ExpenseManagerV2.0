package com.expenseManager.UserProfile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.expenseManager.UserProfile.exception.UserCustomException;
import com.expenseManager.UserProfile.models.Response;
import com.expenseManager.UserProfile.models.User;
import com.expenseManager.UserProfile.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepo;

	public ResponseEntity<Object> getUserProfile(String userName) throws UserCustomException {
		if(StringUtils.isEmpty(userName)) {
			Response response=new Response("User name is null or empty");
			throw new UserCustomException(response);
		}
		User res = profileRepo.findByUserName(userName);
		if(res == null) {
			Response response=new Response("No Entry found for specified name"+ userName);
		throw new UserCustomException(response);
		}
		return new ResponseEntity<Object>(res,HttpStatus.ACCEPTED);
		
	}

}
