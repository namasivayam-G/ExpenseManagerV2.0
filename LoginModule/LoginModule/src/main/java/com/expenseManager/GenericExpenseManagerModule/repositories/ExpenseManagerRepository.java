package com.expenseManager.GenericExpenseManagerModule.repositories;

import org.springframework.data.repository.CrudRepository;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;

public interface ExpenseManagerRepository extends CrudRepository<ExpenseItem, Long>, ExpenseCustomRepo {

	
}
