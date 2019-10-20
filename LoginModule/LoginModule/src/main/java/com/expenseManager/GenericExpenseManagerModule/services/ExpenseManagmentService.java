package com.expenseManager.GenericExpenseManagerModule.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;
import com.expenseManager.GenericExpenseManagerModule.repositories.ExpenseManagerRepository;
import com.expenseManager.GenericExpenseManagerModule.utility.Constants;


@Service
public class ExpenseManagmentService {

	@Autowired
	ExpenseManagerRepository emRepo;
	
	public Collection<ExpenseItem> getAllExpenses(long userId){
		return emRepo.getAllItemsSortedByDate(userId);
	}

	public ExpenseItem saveExpenseForUser(ExpenseItem expense) {
		return emRepo.save(expense);
		
	}
	
	public Collection<ExpenseItem> getMonthlyExpenses(String yearAndMonth, long userId){
		return emRepo.getExpenseByDate(yearAndMonth, yearAndMonth, yearAndMonth, yearAndMonth, userId, yearAndMonth);
	}

	public Collection<ExpenseItem> getMonthlyExpenses(long userId, String year, String month) {
		return emRepo.getExpenseByDate(null, null, month, year, userId, Constants.MONTHLY);
	}

	public Collection<ExpenseItem> getweeklyExpenses(long userId, String year, String month, String fromDate,
			String toDate) {
		return emRepo.getExpenseByDate(fromDate, toDate, month, year, userId, Constants.WEEKLY);
	}

	public Collection<ExpenseItem> getDailyExpenses(long userId, String year, String month, String day) {
		return emRepo.getExpenseByDate(day, null, month, year, userId, Constants.DAILY);
	}
	
	public void deleteExpense(ExpenseItem expense) {
		emRepo.delete(expense);
	}
	
}
