package com.expenseManager.UserProfile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseManager.UserProfile.exception.UserCustomException;
import com.expenseManager.UserProfile.models.Response;
import com.expenseManager.UserProfile.models.User;
import com.expenseManager.UserProfile.repositories.LoginRepositoryImpl;

@Service
public class LoginService {

	@Autowired
	LoginRepositoryImpl loginRepo;

	public Response registerUserProfile(User user) throws UserCustomException {
		try {
			loginRepo.registerUser(user);
		} catch (Exception e) {
			Response response = new Response("Error in registration try with different username");
			throw new UserCustomException(response);
		}
		return new Response("Registered Successfully");
	}

	public Response loginUser(String userName, String password) throws UserCustomException {
		try {
			if(loginRepo.loginUser(userName, password)){
				return  new Response("Logged in");
			}
			else{
				return  new Response("Username or password is wrong");
			}
		} catch (Exception e) {
			Response response = new Response("Username or password is wrong");
			throw new UserCustomException(response);
		}
	}
}