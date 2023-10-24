package com.ianhearne.tvdbexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianhearne.tvdbexam.models.Listening;
import com.ianhearne.tvdbexam.models.User;
import com.ianhearne.tvdbexam.services.ListeningService;
import com.ianhearne.tvdbexam.services.UserService;

@Controller
public class ListeningController {
	@Autowired
	UserService userService;
	
	@Autowired
	ListeningService listeningService;
	
	
	////	GET MAPPINGS    ////
	
	@GetMapping("/home")
	public String homepage(Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		User user = userService.findById((Long) session.getAttribute("userId"));
		
		model.addAttribute("ListeningList", listeningService.getAll());
		model.addAttribute("user", user);
		return "homepage.jsp";
	}
	
	@GetMapping("/listing/new")
	public String addShowForm(@ModelAttribute("newListening") Listening newListening, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("userId", session.getAttribute("userId"));
		return "new-listing.jsp";
	}
	
	@GetMapping("/listing/{id}")
	public String displayShow(@PathVariable Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Listening listening = listeningService.getById(id);
				
		model.addAttribute("listening", listening);
		model.addAttribute("userId", session.getAttribute("userId"));
		return "display-listening.jsp";
	}
	
	@GetMapping("/listings/{id}/edit")
	public String editShow(@PathVariable Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Listening listening = listeningService.getById(id);
		
		//Checks that the show was posted by the user in session
		//Otherwise people could enter the URL and edit other people's data
		if(!listening.getPoster().getId().equals((Long) session.getAttribute("userId"))) {
			return "redirect:/home";
		}
		
		model.addAttribute("listening", listening);
		return "edit-listening.jsp";
	}
	
	////	POST MAPPINGS    ////
	
	@PostMapping("/listings/new")
	public String saveShowToDB(@Valid @ModelAttribute("newListening") Listening newListening, BindingResult result) {
		if(result.hasErrors()) {
			return "/new-listing.jsp";
		}
		listeningService.add(newListening, result);
		if(result.hasErrors()) {
			return "/new-listing.jsp";
		}
		return "redirect:/home";
	}
	
		
	////	PUT MAPPINGS    ////
	
	@PutMapping("/listings/{id}/update")
	public String updateShow(@PathVariable Long id, @Valid @ModelAttribute("listening") Listening listening, BindingResult result) {
		if(result.hasErrors()) {
			return "/edit-litening.jsp";
		}
		listeningService.updateListening(listening, result);
		if(result.hasErrors()) {
			return "/edit-listening.jsp";
		}
		return "redirect:/home";
	}
	
	////	DELETE MAPPINGS    ////
	
	@DeleteMapping("/listings/{id}/delete")
	public String deleteShow(@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		listeningService.deleteListening(id);
		return "redirect:/home";
	}
}
