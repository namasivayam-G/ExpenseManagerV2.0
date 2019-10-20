package com.expenseManager.GenericExpenseManagerModule.controllers;

import java.util.Collection;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;
import com.expenseManager.GenericExpenseManagerModule.services.ExpenseManagmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(description="APIs related to the Expense managment")
@RequestMapping("/expense")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpenseManagementController {

	@Autowired
	ExpenseManagmentService expService;
	
	@ApiOperation(value="Fetch the List of Expenses made by particular user", response=Collection.class,tags="getExpense")
	@GetMapping("/total-expenses/{userId}")
	public Collection<ExpenseItem> getAllExpenses(@PathVariable("userId") long userId) {
		return expService.getAllExpenses(userId);
	}
	
	@PostMapping("/addExpense/{userId}")
	public String addExpense(@RequestBody ExpenseItem expense, @PathVariable("userId") long userId) {
		Date date=java.util.Calendar.getInstance().getTime();  
		expense.setExpenseDate(date);
		expense.setUserId(userId);
		
		ExpenseItem expItm =  expService.saveExpenseForUser(expense);
		return expItm.getExpenseId();
		
	}
	
	@PostMapping("/test")
	public ExpenseItem test(@RequestBody ExpenseItem it) {
		return it;
	}
	
	@GetMapping("/monthly-expense/{userId}/{year}/{month}")
	public Collection<ExpenseItem> getMonthlyExpenses(@PathVariable("userId") long userId,
			@PathVariable("year") String year,
			@PathVariable("month") String month){
		return expService.getMonthlyExpenses(userId, year, month);
		
	}
	
	@GetMapping("/weekly-expense/{userId}/{year}/{month}/{fromDate}/{toDate}")
	public Collection<ExpenseItem> getWeeklyExpenses(@PathVariable("userId") long userId, 
			@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("fromDate") String fromDate,
			@PathVariable("toDate") String toDate){
		return expService.getweeklyExpenses(userId, year, month, fromDate, toDate);
		
	}
	
	@GetMapping("/daily-expense/{userId}/{year}/{month}/{day}")
	public Collection<ExpenseItem> getDailyExpenses(@PathVariable("userId") long userId, 
			@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("day") String day){
		return expService.getDailyExpenses(userId, year, month, day);
	}
	
	@DeleteMapping("/deleteExpense")
	public void deleteExpense(@RequestBody ExpenseItem expense){
		 expService.deleteExpense(expense);
	}
	
}