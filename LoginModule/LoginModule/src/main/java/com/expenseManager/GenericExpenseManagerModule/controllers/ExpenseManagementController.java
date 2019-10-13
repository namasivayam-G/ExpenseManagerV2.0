package com.expenseManager.GenericExpenseManagerModule.controllers;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Collection<ExpenseItem> getAllExpenses(@PathParam("userId") long userId){
		return null;

}
}