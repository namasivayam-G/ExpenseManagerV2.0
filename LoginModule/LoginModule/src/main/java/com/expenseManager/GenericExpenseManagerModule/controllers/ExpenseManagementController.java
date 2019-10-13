package com.expenseManager.GenericExpenseManagerModule.controllers;

import java.util.Collection;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;
import com.expenseManager.GenericExpenseManagerModule.services.ExpenseManagmentService;


@RestController
@RequestMapping("/expense")
public class ExpenseManagementController {

	@Autowired
	ExpenseManagmentService expService;

	@GetMapping("/total-expenses/{userId}")
	public Collection<ExpenseItem> getAllExpenses(@PathVariable("userId") long userId) {
		return expService.getAllExpenses(userId);
	}
	
	@PostMapping("/addExpense/{userId}")
	public void addExpense(@RequestBody ExpenseItem expense, @PathVariable("userId") long userId) {
		Date date=java.util.Calendar.getInstance().getTime();  
		expense.setExpenseDate(date);
		expense.setUserId(userId);
		
		expService.saveExpenseForUser(expense);
		
	}
	
	@PostMapping("/test")
	public ExpenseItem test(@RequestBody ExpenseItem it) {
		return it;
	}
}