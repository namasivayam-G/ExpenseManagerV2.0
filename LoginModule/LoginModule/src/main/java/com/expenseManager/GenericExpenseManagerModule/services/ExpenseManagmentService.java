package com.expenseManager.GenericExpenseManagerModule.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;
import com.expenseManager.GenericExpenseManagerModule.repositories.ExpenseManagerRepository;

@Service
public class ExpenseManagmentService {

	@Autowired
	ExpenseManagerRepository emRepo;
	
	public Collection<ExpenseItem> getAllExpenses(long userId){
		return emRepo.getAllItemsSortedByDate(userId);
	}

	public void saveExpenseForUser(ExpenseItem expense) {
		emRepo.save(expense);
		
	}
}
