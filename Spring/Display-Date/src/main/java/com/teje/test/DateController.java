package com.teje.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    @GetMapping("/")
    public String home() {
        return "index1.jsp";
    }

    @GetMapping("/date1")
    public String displayDate(Model model) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM d, yyyy");
        String formattedDate = dateFormat.format(currentDate);
        model.addAttribute("formattedDate", formattedDate);
        return "date1.jsp";
    }

    @GetMapping("/time1")
    public String displayTime(Model model) {
        Date currentTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(currentTime);
        model.addAttribute("formattedTime", formattedTime);
        return "time1.jsp";
    }
    
   
}

