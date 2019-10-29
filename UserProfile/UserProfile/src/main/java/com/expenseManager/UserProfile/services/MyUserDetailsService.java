package com.expenseManager.UserProfile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expenseManager.UserProfile.models.User;
import com.expenseManager.UserProfile.repositories.UserRepository;
import com.expenseManager.UserProfile.securityConfigs.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepo.findByUserName(username);
		User myUser = new User();
		myUser.setUserName("namas");
		myUser.setPassword("namas");
		if(user == null) {
			return new UserPrincipal(myUser);
		}else {
		return new UserPrincipal(user);
		}
		
	}

}
