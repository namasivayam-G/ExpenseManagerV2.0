package com.expenseManager.GenericExpenseManagerModule.repositories;

import java.util.List;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;

public interface ExpenseCustomRepo {
	

	List<ExpenseItem> getAllItemsSortedByDate(long userId);

}
