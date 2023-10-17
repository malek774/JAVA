package com.example.dojosandninjas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosandninjas.Services.DojoService;
import com.example.dojosandninjas.Services.NinjaService;
import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;

import jakarta.validation.Valid;


@Controller
public class DojoController {
	@Autowired
	private DojoService DojoServ;
	
	@Autowired
	private NinjaService NinjaServ;
	
	//Display Route 
	
	@GetMapping("/dojos/new")
	public String create(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	//Action Route 
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	
		if (result.hasErrors()) {
			
			return "dojo.jsp";
		} else {
			Dojo newDojo = DojoServ.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String ninjasdojo(@PathVariable("id") Long id ,@ModelAttribute("dojo") Dojo dojo,Model model) {
		List<Ninja> Ninjas=NinjaServ.allNinjas();
		model.addAttribute("Ninjas", Ninjas);
		model.addAttribute("Dojo_id", id);
		return "show.jsp";
	}
}
