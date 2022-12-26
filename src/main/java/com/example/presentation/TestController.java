package com.example.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
}
