package com.abid.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abid.expensetrackerapi.entity.Expense;
import com.abid.expensetrackerapi.service.ExpenseService;

import jakarta.validation.Valid;


@RestController
public class ExpenseController {
	
	@Autowired
	public ExpenseService expenseService;
	
	
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		System.out.println(expenseService.getAllExpenses());
		return expenseService.getAllExpenses();
	}
	
	

	@GetMapping("/expenses/{id}")
	public Expense getExpensesUsingId(@PathVariable("id") Long id) {
		return  expenseService.getExpenseById(id);
	}
	
	
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam("id") Long id) {
		expenseService.deleteExpenseById(id);
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}
	
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
		return expenseService.updateExpenseDetails(id, expense);
	}
	
}
