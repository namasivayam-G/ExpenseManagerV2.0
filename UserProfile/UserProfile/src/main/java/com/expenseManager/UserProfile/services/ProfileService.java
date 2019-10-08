package com.expenseManager.UserProfile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.expenseManager.UserProfile.exception.UserNotfoundException;
import com.expenseManager.UserProfile.models.User;
import com.expenseManager.UserProfile.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepo;

	public ResponseEntity<Object> getUserProfile(String userName) throws UserNotfoundException {
		if(StringUtils.isEmpty(userName)) {
			throw new UserNotfoundException("User name is null or empty");
		}
		User res = profileRepo.findByUserName(userName);
		if(res == null) {
		throw new UserNotfoundException("No Entry found for specified name"+userName);
		}
		return new ResponseEntity<Object>(res,HttpStatus.ACCEPTED);
		
	}
}
