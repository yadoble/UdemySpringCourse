package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	public static final String VISTA = "500"; 
	
	@GetMapping("/vistaString")
	public String error(Model model){
		return VISTA;
		
	}
}
