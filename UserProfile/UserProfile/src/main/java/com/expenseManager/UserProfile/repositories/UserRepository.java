package com.expenseManager.UserProfile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseManager.UserProfile.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{	
	
	public User findByUserName(String UserName);

}
