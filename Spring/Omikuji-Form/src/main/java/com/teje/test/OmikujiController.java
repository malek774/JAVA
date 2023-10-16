package com.teje.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class OmikujiController {
    @GetMapping("/omikuji")
    public String omikujiForm() {
        return "omikuji-form"; // This will render the form page.
    }

    @PostMapping("/omikuji/submit")
    public String omikujiSubmit(String question, HttpSession session) {
        // Store the form input in the session.
        session.setAttribute("question", question);
        return "redirect:/omikuji/show";
    }

    @GetMapping("/omikuji/show")
    public String showOmikuji(HttpSession session, Model model) {
        // Retrieve the question from the session.
        String question = (String) session.getAttribute("question");
        model.addAttribute("question", question);
        return "omikuji-show"; // This will render the show page.
    }
}
