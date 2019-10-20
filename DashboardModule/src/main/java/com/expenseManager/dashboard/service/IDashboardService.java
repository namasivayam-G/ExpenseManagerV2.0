package com.expenseManager.dashboard.service;

import java.util.List;
import java.util.Map;

import com.expenseManager.dashboard.models.ExpenseItem;

public interface IDashboardService {
	public Map<String,List<ExpenseItem>> getMonthlyExpensesByCategory(long userId, String year, String month);
	
	public Map<String, List<ExpenseItem>> getweeklyExpensesByCategory(long userId, String year, String month,
			String fromDate, String toDate, String category);
	
	public Map<String, List<ExpenseItem>> getDailyExpensesByCategory(long userId, String year, String month, String day,
			String category);
}
