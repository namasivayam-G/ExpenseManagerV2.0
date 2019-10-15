package com.expenseManager.GenericExpenseManagerModule.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;

public interface ExpenseCustomRepo {
	

	List<ExpenseItem> getAllItemsSortedByDate(long userId);

	Collection<ExpenseItem> getExpenseByDate(String fromDay, String toDay, String month, String year, long UserId,
			String criteria);

}
