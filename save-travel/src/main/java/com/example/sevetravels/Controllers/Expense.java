package com.example.sevetravels.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.sevetravels.Services.ExpenseService;
import com.example.sevetravels.models.ExpenseModel;

import jakarta.validation.Valid;

@Controller
public class Expense {
	@Autowired
	private ExpenseService ExpenseServ;

	@GetMapping("/")
	public String indexpage(Model model) {
		List<ExpenseModel> allExpense = ExpenseServ.ReadExpense();
		model.addAttribute("allExpense", allExpense);
		return "index.jsp";
	}

	// DISPLAY ROUTE
	@GetMapping("/expense")
	public String addexpense(@ModelAttribute("expense") ExpenseModel expense, Model model) {

		List<ExpenseModel> allExpense = ExpenseServ.ReadExpense();
		model.addAttribute("allExpense", allExpense);

		return "index.jsp";
	}

	// ACTION ROUTE
	@PostMapping("/expense/new")
	public String createExpense(@Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<ExpenseModel> allExpense = ExpenseServ.ReadExpense();
			model.addAttribute("allExpense", allExpense);
			return "index.jsp";
		} else {

			ExpenseModel newExpense = ExpenseServ.createExpense(expense);
			return "redirect:/expense";
		}

	}
	
	
	// Display Route - Edit form
	
		@GetMapping("/expense/{id}/edit")
		public String editPage(@PathVariable("id") Long id,@ModelAttribute("expense") ExpenseModel expense, Model model) {
			
			// find that expense with provided id
			ExpenseModel thisExpense = ExpenseServ.findExpense(id);
			
			
			model.addAttribute("OneExpense",thisExpense);
			
			return "edit.jsp";
		}
		
		
		// ACTION ROUTE
		@PutMapping("/expense/{id}/edit")
		public String updateExpense(@Valid @ModelAttribute("expense") ExpenseModel expense,BindingResult result ) {
			if (result.hasErrors()) {
				
				return "edit.jsp";
			} else {
				// if there are no errors update book
				ExpenseServ.updateExpense(expense);
				return "redirect:/expense";
			}
		}
	
	// Show One page
	@GetMapping("/expense/{id}")
	public String showone(@PathVariable("id") Long id, Model model) {
		ExpenseModel thisExpense=ExpenseServ.findExpense(id);
		model.addAttribute("oneexpense",thisExpense);
		return "show.jsp";
	}
	
	
	
	// DELETE
	@DeleteMapping("/expense/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		ExpenseServ.deleteExpense(id);
		return "redirect:/expense";
	}
}
