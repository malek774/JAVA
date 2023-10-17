package com.example.sevetravels.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sevetravels.models.ExpenseModel;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseModel, Long> {
	
	// Read All
		List<ExpenseModel> findAll();
}
