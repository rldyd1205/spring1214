package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = {"/", "index"})
	public String home() {
		System.out.println("메인페이지 호출완료...");
		return "index";
	}
	
	
}
