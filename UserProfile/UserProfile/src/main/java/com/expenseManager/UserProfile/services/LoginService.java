package com.expenseManager.UserProfile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseManager.UserProfile.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepo;
}