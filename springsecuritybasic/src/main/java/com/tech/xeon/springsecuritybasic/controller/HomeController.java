package com.tech.xeon.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/welcome")
	public String loadWelcomePage() {
		return "Welcome to spring security world";
	}
	
}
