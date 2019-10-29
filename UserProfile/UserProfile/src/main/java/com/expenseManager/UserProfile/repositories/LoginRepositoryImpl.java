package com.expenseManager.UserProfile.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.expenseManager.UserProfile.models.User;

@Repository
@Transactional
public class LoginRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	protected Session getCurrentSession()  {
		return entityManager.unwrap(Session.class);
	}
	
	 
	public void registerUser(User user) {
		Session session = getCurrentSession();
		session.save(user);
	}


	public Boolean loginUser(String userName, String password) {
		Session session = getCurrentSession();
		Boolean isLogin=false;
		User exampleUser = new User();
		exampleUser.setUserName(userName);
		exampleUser.setPassword(password);
		Example example =Example.create(exampleUser);
		Criteria criteria =session.createCriteria(User.class).add(example);
		List<User> us= criteria.list();
		if(us.get(0).getPassword().equals(password)){
			isLogin= true;
		}
		return isLogin;
	}
}
