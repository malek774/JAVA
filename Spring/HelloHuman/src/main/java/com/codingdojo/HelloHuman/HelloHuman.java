package com.codingdojo.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name) {
    	if(name!=null) {
        return "Hello " + name;
    	}
    	else {
			return "Hello Human";
		}
    }
	}