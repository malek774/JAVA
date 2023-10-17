package com.example.sevetravels.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sevetravels.Repository.ExpenseRepository;
import com.example.sevetravels.models.ExpenseModel;

@Service
public class ExpenseService {
	// CRUD
	@Autowired
	private ExpenseRepository ExpenseRepo;
	
	
	// READ ALL
	public List<ExpenseModel> ReadExpense() {
		return ExpenseRepo.findAll();
	}
	
	
		// CREATE
		public ExpenseModel createExpense(ExpenseModel E) {
			return ExpenseRepo.save(E);
		}
	
	
		// READ ONE
		public ExpenseModel findExpense(Long id) {
			
			Optional<ExpenseModel> OneExpense = ExpenseRepo.findById(id);
			if(OneExpense.isPresent()) {
				return OneExpense.get();
			}else {
				return null;
			}
		}
		
		// UPDATE 
		public ExpenseModel updateExpense(ExpenseModel E) {
			return ExpenseRepo.save(E);
		}
		
		// DELETE
		public void deleteExpense(Long id) {
			ExpenseRepo.deleteById(id);
		}
	
	
	
}
