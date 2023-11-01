package com.abid.expensetrackerapi.service;

import java.util.List;

import com.abid.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	
	public List<Expense> getAllExpenses();
	
	public Expense getExpenseById(Long id);
	
	public void deleteExpenseById(Long id);
	
	public Expense saveExpenseDetails(Expense expense);
	
	public Expense updateExpenseDetails(Long id, Expense expense);
}


