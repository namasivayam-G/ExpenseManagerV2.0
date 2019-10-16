package com.expenseManager.dashboard.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseManager.dashboard.models.ExpenseItem;
import com.expenseManager.dashboard.service.DashboardService;


@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;
	
	@GetMapping("/monthly-expense-by-category/{userId}/{year}/{month}/{category}")
	public Map<String,List<ExpenseItem>> getMonthlyExpensesByCategory(@Valid @NotNull @PathVariable(value="userId",required=false) long userId,
			@PathVariable("year") String year,
			@PathVariable("month") String month,@PathVariable("category") String category){
		return dashboardService.getMonthlyExpensesByCategory(userId, year, month,category);
	}
	
	@GetMapping("/weekly-expense-by-category/{userId}/{year}/{month}/{fromDate}/{toDate}")
	public Map<String,List<ExpenseItem>> getWeeklyExpensesByCategory(@PathVariable("userId") long userId, 
			@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("fromDate") String fromDate,
			@PathVariable("toDate") String toDate,@PathVariable("category") String category){
		return dashboardService.getweeklyExpensesByCategory(userId, year, month, fromDate, toDate,category);
		
	}
	
	@GetMapping("/daily-expense-by-category/{userId}/{year}/{month}/{day}")
	public Map<String,List<ExpenseItem>> getDailyExpensesByCategory(@PathVariable("userId") long userId, 
			@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("day") String day,@PathVariable("category") String category){
		return dashboardService.getDailyExpensesByCategory(userId, year, month, day,category);
	}
}
