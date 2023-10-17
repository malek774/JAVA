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
public class NinjaController {
	@Autowired
	private NinjaService NinjaServ;
	@Autowired
	private DojoService DojoServ;
	
	
	
	//Display Route 
	
		@GetMapping("/ninjas/new")
		public String create(@ModelAttribute("ninja") Ninja ninja, Model model) {
			List<Dojo> listdojos = DojoServ.allDojos();
			model.addAttribute("ListDojos", listdojos);
			return "ninja.jsp";
		}
		
		//Action Route 
		@PostMapping("/ninjas")
		public String createBook(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
		
			if (result.hasErrors()) {
				List<Dojo> listdojos = DojoServ.allDojos();
				model.addAttribute("ListDojos", listdojos);
				return "ninja.jsp";
			} else {
				Ninja newNinja = NinjaServ.createNinja(ninja);
				return "redirect:/ninjas/new";
			}
		}
		
		
	
}
