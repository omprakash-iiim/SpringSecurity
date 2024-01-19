package com.tech.xeon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

	@GetMapping("/dashboard")
	public String loadDashboard() {
		return "users dashboard";
	}
	
}
